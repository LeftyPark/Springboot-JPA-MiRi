package com.cos.miribogi.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder  //3
public class ResponseDto<T> {   //fffffffffffffffffffff
    int status;
    T data;
}
