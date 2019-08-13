package com.iilei.authority.controller;

import com.iilei.authority.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/login")
public interface LoginController {

    @PostMapping(value = "/login")
    public ResponseData login(String username, String password);

    @GetMapping(value = "/logout")
    public ResponseData logout();

    @GetMapping(value = "/error")
    public ResponseData error();
}
