package com.iilei.authority.controller;

import com.iilei.authority.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MyErrorController implements ErrorController {
    @Autowired
    private HttpServletRequest httpServletRequest;
    private static final String ERROR_PATH = "/error";

    /**
     * 主要是登陆后的各种错误路径  404页面改为返回此json
     * 未登录的情况下,大部分接口都已经被shiro拦截,返回让用户登录了
     *
     * @return 501的错误信息json
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ResponseData handleError() {
        String error = (String) httpServletRequest.getAttribute("error");
        if (error == null) {
            return ResponseData.fail(404, null);
        }else{
            Integer error_code = (Integer) httpServletRequest.getAttribute("error_code");
            return ResponseData.fail(error_code, error);
        }
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
