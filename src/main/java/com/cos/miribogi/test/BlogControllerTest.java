package com.cos.miribogi.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//1
// @RestController  
@Controller
public class BlogControllerTest {
    
    @GetMapping("test/hello")
    public String hi(){
        return "<h1>hi miri</h1>";
    }

    @GetMapping("/test/jsp")
    public String hi1(){
        return "/index";
    }

    @GetMapping("/test/html")
    public String hi2(){
        return "/index.html";
    }
}
