package com.cos.miribogi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.miribogi.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{

    // Select * from user where username = 1?;
    Optional<User> findByUsername(String username);
    
    
    

}

    // 전통로그인
    // select * from user where username = ? and password = ?;  ((JAP Naming쿼리))
    // User findByUsernameAndPassword(String username, String password);  

    // @Query(value = "select * from user where username = ? and password = ?;")
    // User login(String username, String password);
