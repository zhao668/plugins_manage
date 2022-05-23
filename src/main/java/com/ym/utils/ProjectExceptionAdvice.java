package com.ym.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//SpringMvc的异常处理器
public class ProjectExceptionAdvice {

    @ExceptionHandler
    public R doException(Exception ex) {
        ex.printStackTrace();
        return new R(false,null,"服务器故障，请稍后再试");
    }
}
