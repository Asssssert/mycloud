package com.iilei.authority.controller;

import com.iilei.authority.dto.ResponseData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/user")
public interface UserController {

    @GetMapping(value = "/get/userInfo")
    @RequiresPermissions("user:get:userInfo")
    public ResponseData getUserInfoByToken();

}
