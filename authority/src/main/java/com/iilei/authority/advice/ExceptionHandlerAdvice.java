package com.iilei.authority.advice;

import com.iilei.authority.dto.ResponseData;
import com.iilei.authority.exception.LoginException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    @Autowired
    private HttpServletRequest hsr;

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseData unauthorizedException(Exception exception) {
        return ResponseData.fail(HttpStatus.UNAUTHORIZED.value(), "你没有该权限");
    }

//    @ExceptionHandler(ShiroException.class)
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseData loginException(AccountException exception) {
//        return ResponseData.fail(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
//    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseData badRequest(Exception exception) {
        String error = (String) hsr.getAttribute("error");
        if (error == null) {
            return ResponseData.fail(404, null);
        }else{
            Integer error_code = (Integer) hsr.getAttribute("error_code");
            return ResponseData.fail(error_code, error);
        }
//        return ResponseData.fail(HttpStatus.BAD_REQUEST.value(), "token无效,请重新登录");
    }

}
