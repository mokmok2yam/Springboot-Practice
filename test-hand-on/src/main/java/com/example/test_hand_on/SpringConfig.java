package com.example.test_hand_on;

import com.example.test_hand_on.repository.JdbcTemplateMemberRepository;
import com.example.test_hand_on.repository.JpaMemberRepository;
import com.example.test_hand_on.repository.MemberRepository;
import com.example.test_hand_on.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
   // public final DataSource dataSource;
    public final EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean//이메서드가 반환하는 객체는 빈으로 등록해!
    MemberService memberService(){
        return new MemberService(memberRepository());//서비스는 리포지토리를 필요로하니까 괄호 안에 연결
    }
    @Bean
    MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }

}
