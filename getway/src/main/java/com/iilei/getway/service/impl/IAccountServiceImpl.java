package com.iilei.getway.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.entity.Account;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.api.service.AuthorityService;
import com.iilei.getway.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IAccountServiceImpl implements IAccountService {

    @Autowired
    private AuthorityService authorityService;

    @Override
    public Account findByUsername(String username) {
        Account account = authorityService.accountFindByUsername(username);
        System.out.println("gatway:" + account);
        return account;
    }

    @Override
    public void add(AccountAdd params) {

    }

    @Override
    public void del(Integer[] ids) {

    }

    @Override
    public void upd(AccountUpd params) {

    }

    @Override
    public Account findById(Integer id) {
        return null;
    }

    @Override
    public Page<Account> listByPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public void lock(Integer[] ids, Integer lock) {

    }
}
