package com.cos.miribogi.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//1
@RestController  
public class BlogControllerTest {
    
    @GetMapping("test/hello")
    public String hi(){
        return "<h1>hi miri</h1>";
    }
}
