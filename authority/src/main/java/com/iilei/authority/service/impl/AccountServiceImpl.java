package com.iilei.authority.service.impl;

import com.auth0.jwt.JWT;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.iilei.authority.dto.account.AccountGetDto;
import com.iilei.authority.dto.account.AccountInfoDto;
import com.iilei.authority.dto.account.AccountListDto;
import com.iilei.authority.entity.Account;
import com.iilei.authority.exception.ParamException;
import com.iilei.authority.mapper.AccountMapper;
import com.iilei.authority.params.account.AccountAdd;
import com.iilei.authority.params.account.AccountUpd;
import com.iilei.authority.service.IAccountService;
import com.iilei.authority.service.RedisService;
import com.iilei.authority.utils.BeanValidator;
import com.iilei.authority.utils.DataUtils;
import com.iilei.authority.utils.JWTUtil;
import com.iilei.authority.utils.PageUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.iilei.authority.utils.Constant.ACCOUNT_LOCK;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
    @Autowired
    private RedisService redisService;

    @Override
    public Account findByUsername(String username) {
        EntityWrapper<Account> wrapper = new EntityWrapper<>();
        wrapper.eq("account", username);
        Account account = selectOne(wrapper);
        return account;
    }

    @Override
    public AccountInfoDto getUserInfoByToken(String token) {
        String username = JWTUtil.getUsername(token);
        Account account = findByUsername(username);
        AccountInfoDto dto = DataUtils.copyProperties(account, new AccountInfoDto());
        return dto;
    }

    @Override
    public String login(String username, String password) {
        EntityWrapper<Account> wrapper = new EntityWrapper<>();
        wrapper
                .eq("account", username)
                .eq("password", new Md5Hash(password).toString());
        Account account = selectOne(wrapper);
        if (account == null) {
            throw new AccountException("用户名或密码不正确");
        }
        if (account.getLock() == ACCOUNT_LOCK) {
            throw new LockedAccountException("该用户已被锁定");
        }
        String token = JWTUtil.sign(username, account.getPassword());
        redisService.set(username, token, 24 * 60 * 60 * 1000);//一天
        return token;
    }

    @Override
    public void logout(String token) {
        String username = JWTUtil.getUsername(token);
        redisService.del(username, token);
    }

    @Override
    public void add(AccountAdd params) {
        BeanValidator.check(params);
        Account a = DataUtils.copyProperties(params, new Account());
        Account account = findByUsername(a.getAccount());
        if (account != null) {
            throw new ParamException("该用户名已被使用");
        }
        a.setCreate_time(new Date());
        a.setUpdate_time(new Date());
        a.setPassword(new Md5Hash(a.getPassword()).toString());//加密
        insert(a);
    }

    @Override
    public void del(Integer[] ids) {
        for (Integer id : ids) {
            Account account = checkById(id);
            if (account.getLevel() == 1) {
                throw new ParamException("id为【" + id + "】的用户不能删除");
            }
        }
        for (Integer id : ids) {
            deleteById(id);
        }
    }

    @Override
    public void upd(AccountUpd params) {
        BeanValidator.check(params);
        Account a = checkById(params.getId());
        DataUtils.copyProperties(params, a);
        a.setPassword(new Md5Hash(a.getPassword()).toString());//加密
        a.setUpdate_time(new Date());
        updateAllColumnById(a);
    }


    @Override
    public AccountGetDto findById(Integer id) {
        Account account = checkById(id);
        return DataUtils.copyProperties(account, new AccountGetDto());

    }

    @Override
    public Page<Account> listByPage(Integer page, Integer size) {
        Page accounts = selectPage(PageUtils.pageSizeCheck(page, size));
        List<Account> records = accounts.getRecords();
        List<AccountListDto> dtoList = Lists.newArrayList();
        records.forEach(account -> {
            AccountListDto dto = DataUtils.copyProperties(account, new AccountListDto());
            dtoList.add(dto);
        });
        accounts.setRecords(dtoList);
        accounts.setTotal(selectCount(null));
        return accounts;
    }

    @Override
    public void lock(Integer[] ids, Integer lock) {
        for (Integer id : ids) {
            checkById(id);
        }
        for (Integer id : ids) {
            Account account = checkById(id);
            account.setLock(lock);
            account.setUpdate_time(new Date());
            updateAllColumnById(account);
        }
    }

    /**
     * 根据ID校验是否存在
     *
     * @param id
     * @return
     */
    private Account checkById(Integer id) {
        Account selectById = selectById(id);
        if (selectById == null) {
            throw new ParamException("id为【" + id + "】的用户不存在");
        }
        return selectById;
    }
}
