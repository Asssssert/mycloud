package com.iilei.authority.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.entity.Account;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.authority.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IAccountServiceImpl implements IAccountService {
    @Autowired
    private AccountService accountService;

    @Override
    public Account findByUsername(String username) {
        return accountService.findByUsername(username);
    }

    @Override
    public void add(AccountAdd params) {
        accountService.add(params);
    }

    @Override
    public void del(Integer[] ids) {
        accountService.del(ids);
    }

    @Override
    public void upd(AccountUpd params) {
        accountService.upd(params);
    }

    @Override
    public Account findById(Integer id) {
        return accountService.findById(id);
    }

    @Override
    public Page<Account> listByPage(Integer page, Integer size) {
        return accountService.listByPage(page, size);
    }

    @Override
    public void lock(Integer[] ids, Integer lock) {
        accountService.lock(ids, lock);
    }
}
