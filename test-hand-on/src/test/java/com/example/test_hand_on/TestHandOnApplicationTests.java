package com.example.test_hand_on;

import com.example.test_hand_on.domain.Member;
import com.example.test_hand_on.repository.MemberRepository;
import com.example.test_hand_on.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class TestHandOnApplicationTests {
	MemberRepository repository = new MemoryMemberRepository();

	@AfterEach
	public void clear(){
		repository.clearStore();
	}
	@Test
	void sava(){
		Member member = new Member();
		member.setName("String");
		repository.save(member);
		Member result=repository.findById(member.getId()).get();
		assertThat(result).isEqualTo(member);
	}
	@Test
	void findByName(){
		Member member = new Member();
		member.setName("spring1");
		repository.save(member);
		Member result=repository.findByname("spring1").get();
		assertThat(result).isEqualTo(member);
	}
	@Test
	void findAll(){
		Member member=new Member();
		Member member1=new Member();
		member.setName("spring1");
		member1.setName("spring2");
		repository.save(member);
		repository.save(member1);
		List<Member> result=repository.findAll();
		assertThat(result.size()).isEqualTo(2);
	}


}
