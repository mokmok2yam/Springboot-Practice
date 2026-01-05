package com.example.test_hand_on.service;

import com.example.test_hand_on.domain.Member;
import com.example.test_hand_on.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforEach(){
        memberRepository=new MemoryMemberRepository();
        memberService=new MemberService(memberRepository);
    }


    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }
    @Test
    void join() {
        //Given
        Member member = new Member();
        member.setName("spring");
        //When
        memberService.join(member);
        //Then
        Member findMember=memberRepository.findByname(member.getName()).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    void 중복확인(){
        //Given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring1");
        //When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                ()->memberService.join(member2));
        //Then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
        //Given 2명을 가입시킴
        Member member1 = new Member();
        member1.setName("spring1");
        Member member2 =new Member();
        member2.setName("spring2");
        //When 전체목록을조회한다.
        memberService.join(member1);
        memberService.join(member2);
        List <Member> result=memberService.findMembers();
        //then 목록의 개수가 2개인지 확인한다.
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findOne() {
        //Given 멤버 한명 생성
        Member member=new Member();
        member.setName("spring1");
        //When 가입 시키고 그아이디로 조회
        memberService.join(member);
        Member result=memberService.findOne(member.getId()).get();
        //Then 이름같은지 확인
       assertThat(result.getName()).isEqualTo("spring1");
    }
}