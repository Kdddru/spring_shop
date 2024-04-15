package com.dudu.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//implements => interface 처럼 똑같은 규격으로 하고있는지 검사
@Service
@RequiredArgsConstructor
public class GetUserDetailService implements UserDetailsService {

  private final MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<Member> result = memberRepository.findAllByUsername(username);
    //값없는경우
    if(result.isEmpty()){
      throw new UsernameNotFoundException("찾는 아이디 없음");
    }

    var user = result.get();
    List<GrantedAuthority> a = new ArrayList<>();
    a.add(new SimpleGrantedAuthority("일반유저"));



    return new User(user.getUsername(),user.getPassword() , a);
  }

}
