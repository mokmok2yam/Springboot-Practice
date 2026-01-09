package com.example.test_hand_on;

import com.example.test_hand_on.repository.JdbcMemberRepository;
import com.example.test_hand_on.repository.MemberRepository;
import com.example.test_hand_on.repository.MemoryMemberRepository;
import com.example.test_hand_on.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    public final DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean//이메서드가 반환하는 객체는 빈으로 등록해!
    MemberService memberService(){
        return new MemberService(memberRepository());//서비스는 리포지토리를 필요로하니까 괄호 안에 연결
    }
    @Bean
    MemberRepository memberRepository(){
        return new JdbcMemberRepository(dataSource);// 실제 데이터베이스와 연결하기 위해 DataSource가 필요하므로 생성자에 넣어줍니다.
    }

}
