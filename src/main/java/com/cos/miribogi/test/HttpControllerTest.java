package com.cos.miribogi.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//2
@RestController // RestController 데이터 요청
public class HttpControllerTest {

    // 인터넷 브라우저 요청은 오직 get요청만 가능하다
    @GetMapping("/http/get")
    public String getTest(@RequestParam int id, @RequestParam String username) {
        // Member로 한번에 받을 수 있음. (@RequsetParam말고)
        return "get 요청 : " + id+ ", " + username;
    }

    @PostMapping("/http/post")
    public String PostTest(@RequestBody Member m) {
        // return "post 요청 : " + m.getId() + ", "+ m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
        return "post 요청 : " + m.getId() + ", "+ m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    @PutMapping("/http/put")
    public String PutTest(@RequestBody Member m) {
        return "put 요청 : " + m.getId() + ", " + m.getPassword();
    }
    
    @DeleteMapping("/http/delete")
    public String DeleteTest() {
        return "delete 요청";
    }

}
