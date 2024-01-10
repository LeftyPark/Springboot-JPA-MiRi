package com.cos.miribogi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.miribogi.model.RoleType;
import com.cos.miribogi.model.User;
import com.cos.miribogi.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;
    


    @Transactional
    public void 회원가입(User user) {
        
        String rawPassword = user.getPassword(); // 원 비번
        String encPassword = encoder.encode(rawPassword);  // 해쉬
        user.setPassword(encPassword);
        user.setRole(RoleType.USER); // 자동으로 넣거나 입력되지 않은 것은 직접 셑해준다.
        
        userRepository.save(user);
    }

    @Transactional
    public void 회원수정(User user) {
        User persistance = userRepository.findById(user.getId()).orElseThrow(() ->{
            return new IllegalArgumentException("회원찾기 실패");
        });

        String rawPwd = user.getPassword();
        String encPwd = encoder.encode(rawPwd);

        persistance.setPassword(encPwd);
        persistance.setEmail(user.getEmail());
        
    }

}



    // 전통로그인
    // @Transactional(readOnly = true)  // selec할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료(정합성)
    // public User 로그인(User user) {
    //     return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    // }  