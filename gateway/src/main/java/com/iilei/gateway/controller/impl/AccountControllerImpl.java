package com.iilei.gateway.controller.impl;

import com.iilei.api.vo.ResponseData;
import com.iilei.gateway.controller.AccountController;
import com.iilei.gateway.service.IAccountService;
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
    public ResponseData findByUsername(String username) {
        return ResponseData.success(accountService.findByUsername(username));
    }

}
