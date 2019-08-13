package com.iilei.authority.advice;

import com.iilei.authority.dto.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseData unauthorizedException(Exception exception) {
        return ResponseData.fail(HttpStatus.UNAUTHORIZED.value(), "你没有该权限");
    }

}
