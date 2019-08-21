package com.iilei.basicsauthority.controller.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.basicsauthority.controller.AccountController;
import com.iilei.basicsauthority.entity.Account;
import com.iilei.basicsauthority.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class AccountControllerImpl implements AccountController {
    @Autowired
    private IAccountService accountService;

    @Override
    public Account findByUsername(String username) {
        return accountService.findByUsername(username);
    }

    @Override
    public boolean add(AccountAdd params) {
        try {
            accountService.add(params);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean del(Integer[] ids) {
        try {
            accountService.del(ids);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean upd(AccountUpd params) {
        try {
            accountService.upd(params);
        } catch (Exception e) {
            return false;
        }
        return true;
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
    public boolean lock(Integer[] ids, Integer lock) {
        try {
            accountService.lock(ids, lock);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
