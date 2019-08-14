package com.iilei.authority.controller.impl;

import com.iilei.authority.controller.UserController;
import com.iilei.authority.dto.ResponseData;
import com.iilei.authority.dto.account.AccountInfoDto;
import com.iilei.authority.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class UserControllerImpl implements UserController {
    @Autowired
    private HttpServletRequest hsr;
    @Autowired
    private IAccountService accountService;

    @Override
    public ResponseData getUserInfoByToken() {
        String token = hsr.getHeader("Authorization");
        AccountInfoDto dto = null;
        try {
            dto = accountService.getUserInfoByToken(token);
        } catch (Exception e) {
            return ResponseData.fail(50001, e.getMessage());
        }
        return ResponseData.success(dto);
    }
}
