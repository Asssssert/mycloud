package com.iilei.authority.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.iilei.authority.entity.Account;
import com.iilei.authority.mapper.AccountMapper;
import com.iilei.authority.service.IAccountService;
import org.springframework.stereotype.Service;

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

    @Override
    public Account findByUsername(String username) {
        EntityWrapper<Account> wrapper = new EntityWrapper<>();
        wrapper.eq("account", username);
        Account account = selectOne(wrapper);
        return account;
    }

    @Override
    public Account login(String username, String password) {
        EntityWrapper<Account> wrapper = new EntityWrapper<>();
        wrapper
                .eq("account", username)
                .eq("password", password);
        Account account = selectOne(wrapper);
        return account;
    }
}
