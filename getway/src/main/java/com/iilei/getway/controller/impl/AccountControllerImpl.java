package com.iilei.getway.controller.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.entity.Account;
import com.iilei.api.service.AuthorityService;
import com.iilei.getway.controller.AccountController;
import com.iilei.getway.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class AccountControllerImpl implements AccountController {
//    @Autowired
//    private AuthorityService authorityService;
    @Autowired
    private IAccountService accountService;

    @Override
    public Account findByUsername(String username) {
        return accountService.findByUsername(username);
    }

}
