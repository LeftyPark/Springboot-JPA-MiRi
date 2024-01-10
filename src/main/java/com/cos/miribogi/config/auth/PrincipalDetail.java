package com.cos.miribogi.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.miribogi.model.User;

import lombok.Getter;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행항고 완료되면 UserDetails 타입의 오브젝트를
//  스프링 시큐리티의 고유한 세션저장소에 저장을 해준다
@Getter
public class PrincipalDetail implements UserDetails {
    private User user; // 객체를 포함하고 있는 것 >> 컴포지션 (vs. 익스텐즈는 상속)

    public PrincipalDetail(User user){
        this.user = user;
    }

    @Override
    public String getPassword() {

        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    // 계정의 권한 목록을 리턴한다
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> {
            return "ROLE_" + user.getRole();
        });
        // 아래를 위 한줄로
        // collectors.add(new GrantedAuthority() {
        //
        // @Override
        // public String getAuthority() {
        // return "ROLE_"+user.getRole();
        // }
        // });

        return collectors;
    }

}
