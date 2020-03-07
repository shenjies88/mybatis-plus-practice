package com.shenjies88.practice.mybatispluspractice.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@ResponseStatus(HttpStatus.OK)
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public HttpResult exceptionHandler(Exception e) {
        String message = e.getMessage();
        if (message == null) {
            message = e.getClass().getSimpleName();
        }
        log.error(message, e);
        return HttpResult.fail(message);
    }
}
