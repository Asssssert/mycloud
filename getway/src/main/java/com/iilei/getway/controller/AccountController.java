package com.iilei.getway.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.entity.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/test")
public interface AccountController {

    @GetMapping(value = "/test")
    Account findByUsername(String username);

}
