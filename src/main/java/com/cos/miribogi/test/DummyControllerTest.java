package com.cos.miribogi.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.miribogi.model.RoleType;
import com.cos.miribogi.model.User;
import com.cos.miribogi.repository.UserRepository;

import jakarta.transaction.Transactional;

@RestController
public class DummyControllerTest {

    @Autowired
    private UserRepository userRepository;

    // 삭제
    @DeleteMapping("/dummy/user/{id}")
    public String userDelete(@PathVariable int id) {

        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return "삭제가 실패하였습니다.";
        }

        return "삭제 완료.";
    }

    // 업데이트
    @Transactional
    @PutMapping("dummy/user/{id}")
    public User updatUser(@RequestBody User requestUser, @PathVariable int id) {

        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("수정이 실패하였습니다");
        });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

        return user;
    }

    // 유저 페이징 조회
    @GetMapping("/dummy/user")
    public Page<User> pageList(
            @PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<User> pagingUser = userRepository.findAll(pageable);
        List<User> users = pagingUser.getContent();

        return pagingUser;
    }

    // 유저 전체 조회
    @GetMapping("/dummy/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    // 유저 상세 조회
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {

        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() { // ffffffffffffffff

            @Override
            public IllegalArgumentException get() { // ffffffffffffffffff
                return new IllegalArgumentException("해당유저는 없다 id : " + id);
            }
        });

        // 위 코드의 람다식 표현
        // User user = userRepository.findById(id).orElseThrow(()->{
        // return new IllegalArgumentException("해당 사용자가 없습니다.");
        // });

        return user;
    }

    // 회원가입
    @PostMapping("/dummy/join")
    public String join(User user) {

        System.out.println("username : " + user.getUsername());
        System.out.println("password : " + user.getPassword());
        System.out.println("email : " + user.getEmail());
        System.out.println("role : " + user.getRole());
        System.out.println("createDate : " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);

        return "회원가입 완료";
    }
}
