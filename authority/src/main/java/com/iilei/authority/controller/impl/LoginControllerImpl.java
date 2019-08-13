package com.iilei.authority.controller.impl;

import com.iilei.authority.controller.LoginController;
import com.iilei.authority.dto.ResponseData;
import com.iilei.authority.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class LoginControllerImpl implements LoginController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private HttpServletRequest hsr;

    @Override
    public ResponseData login(String username, String password) {
        String token = null;
        try {
            token = accountService.login(username, password);
        } catch (Exception e) {
            return ResponseData.fail(10001, e.getMessage());
        }
        return ResponseData.success("登录成功", token);
    }

    @Override
    public ResponseData logout() {
        String token = hsr.getHeader("Authorization");
        if (token == null) {
            return ResponseData.success("已注销");
        } else {
            accountService.logout(token);
        }
        return ResponseData.success("注销成功");
    }

    @Override
    public ResponseData error() {
        return ResponseData.fail(10002, "请登录");
    }
}
