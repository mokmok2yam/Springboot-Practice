package com.example.test_hand_on.service;

import com.example.test_hand_on.domain.Member;
import com.example.test_hand_on.repository.MemberRepository;
import com.example.test_hand_on.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }
    /*
     * 회원가입 로직
     * */
    public Long join(Member member) {
        //중복검사 로직
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId ){
        return memberRepository.findById(memberId);
    }


    private void validateDuplicateMember(Member member) {
        memberRepository.findByname(member.getName())
                       .ifPresent(m->{
                           throw new IllegalStateException("이미 존재하는 회원입니다.");
                       });
    }
}
