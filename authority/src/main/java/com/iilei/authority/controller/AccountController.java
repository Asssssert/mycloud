package com.iilei.authority.controller;

import com.iilei.authority.dto.ResponseData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/account")
public interface AccountController {

    @GetMapping(value = "/test1")
    @RequiresPermissions("account:test1")
    public ResponseData test1();

    @GetMapping(value = "/test2")
    @RequiresPermissions("account:test1")
    public ResponseData test2();

    @GetMapping(value = "/test3")
    @RequiresPermissions("account:test2")
    public ResponseData test3();
}
