package com.iilei.gateway.advice;

import com.iilei.api.exception.ParamException;
import com.iilei.api.vo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ParamException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseData unauthorizedException(Exception exception) {
        return ResponseData.success(exception.getMessage());
    }

}
