package com.iilei.authority.controller.impl;

import com.iilei.authority.controller.AccountController;
import com.iilei.authority.dto.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class AccountControllerImpl implements AccountController {
    @Override
    public ResponseData test1() {
        return ResponseData.success("测试1");
    }

    @Override
    public ResponseData test2() {
        return ResponseData.success("测试2");
    }

    @Override
    public ResponseData test3() {
        return ResponseData.success("测试3");
    }
}
