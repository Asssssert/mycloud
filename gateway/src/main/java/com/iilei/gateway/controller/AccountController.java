package com.iilei.gateway.controller;

import com.iilei.api.vo.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/test")
public interface AccountController {

    @GetMapping(value = "/test")
    ResponseData findByUsername(String username);

}
