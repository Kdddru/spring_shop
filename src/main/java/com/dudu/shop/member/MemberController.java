package com.dudu.shop.member;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

  private final MemberRepository memberRepository;


  @GetMapping("/join")
  String join(){

    return "join.html";
  }
  
  //유저 회원가입
  @PostMapping("/member")
  String addMember(@ModelAttribute Member member) {
    String password = member.getPassword();
    if(password.length() > 8){
      //해쉬된 비밀번호
      var hashPassWord = new BCryptPasswordEncoder().encode(password);
      member.setPassword(hashPassWord);

      memberRepository.save(member);

      return "redirect:/list";
    }
    else {

      return "join.html";
    }

  }
}
