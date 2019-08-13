package com.iilei.authority.controller;

import com.iilei.authority.dto.ResponseData;
import com.iilei.authority.params.account.AccountLogin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/login")
public interface LoginController {

    @PostMapping(value = "/login")
    public ResponseData login(@RequestBody AccountLogin params);

    @GetMapping(value = "/logout")
    public ResponseData logout();

    @GetMapping(value = "/error")
    public ResponseData error();
}
