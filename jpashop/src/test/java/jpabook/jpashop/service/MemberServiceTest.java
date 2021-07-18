package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;
    //@Autowired EntityManager em;


    @Test
    //@Rollback(value = false)
    // Rollback에 false를 하면 insert 가 진짜 들어간다.
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long savedId = memberService.join(member);

        //then
        //em.flush(); //  쿼리 확인
        assertEquals(member, memberRepository.findOne(savedId));
    }

    //try - catch 는 생략할 수 있다
    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member(); member1.setName("kim");
        Member member2 = new Member(); member2.setName("kim");

        //When
        memberService.join(member1);
        memberService.join(member2);

        //then
        fail("예외가 발생해야 한다.");
    }
}