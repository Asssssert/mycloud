package com.iilei.authority.controller.impl;

import com.iilei.authority.controller.LoginController;
import com.iilei.authority.dto.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class LoginControllerImpl implements LoginController {
    @Override
    public ResponseData login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, new Md5Hash(password).toString());
        try {
            subject.login(token);
        } catch (AccountException e) {
            return ResponseData.fail(10001, e.getMessage());
        }
        return ResponseData.success("登录成功");
    }

    @Override
    public ResponseData logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResponseData.success("注销成功");
    }

    @Override
    public ResponseData error() {
        return ResponseData.fail(10002, "请登录");
    }
}
