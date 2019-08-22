package com.iilei.basicsauthority.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.iilei.api.dto.account.AccountDto;
import com.iilei.api.exception.ParamException;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.api.utils.BeanValidator;
import com.iilei.api.utils.DataUtils;
import com.iilei.api.utils.PageUtils;
import com.iilei.basicsauthority.entity.Account;
import com.iilei.basicsauthority.mapper.AccountMapper;
import com.iilei.basicsauthority.service.IAccountService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-21
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Override
    public AccountDto findByUsername(String username) {
        EntityWrapper<Account> wrapper = new EntityWrapper<>();
        wrapper.eq("account", username);
        Account account = selectOne(wrapper);
        AccountDto dto = DataUtils.copyProperties(account, new AccountDto());
        return dto;
    }

    @Override
    public void add(AccountAdd params) {
        BeanValidator.check(params);
        Account a = DataUtils.copyProperties(params, new Account());
        AccountDto account = findByUsername(a.getAccount());
        if (account != null) {
            throw new ParamException("该用户名已被使用");
        }
        a.setCreate_time(new Date());
        a.setUpdate_time(new Date());
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
        a.setUpdate_time(new Date());
        updateAllColumnById(a);
    }

    @Override
    public AccountDto findById(Integer id) {
        Account account = checkById(id);
        AccountDto dto = DataUtils.copyProperties(account, new AccountDto());
        return dto;
    }

    @Override
    public Page<AccountDto> listByPage(Integer page, Integer size) {
        Page accounts = selectPage(PageUtils.pageSizeCheck(page, size));
        List<AccountDto> dtoList = Lists.newArrayList();
        accounts.getRecords().forEach(a -> {
            AccountDto dto = DataUtils.copyProperties(a, new AccountDto());
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
