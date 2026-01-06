package com.example.test_hand_on;

import com.example.test_hand_on.repository.MemberRepository;
import com.example.test_hand_on.repository.MemoryMemberRepository;
import com.example.test_hand_on.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean//이메서드가 반환하는 객체는 빈으로 등록해!
    MemberService memberService(){
        return new MemberService(memberRepository());//서비스는 리포지토리를 필요로하니까 괄호 안에 연결
    }
    @Bean
    MemberRepository memberRepository(){
        return new MemoryMemberRepository(); //인터페이스말고 구현체!!! 를 등록
    }

}
