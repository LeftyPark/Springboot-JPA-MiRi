package com.cos.miribogi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.miribogi.dto.ResponseDto;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {  //fffffffffffffffffffffffffffff
    
    @ExceptionHandler(value = Exception.class)
    public ResponseDto<String> handlerArgementException(Exception e){
        // return "<H1>"+e.getMessage()+"</H1>";
        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
