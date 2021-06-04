package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//데이터 변경은 트랜잭션 안에서 이뤄진다.
// JPA가 조회하는 부분에서 좀 더 최적화 하는 옵션 (readOnly = true)
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // lombok 에서 check
public class MemberService {

    //@Autowired
    private final MemberRepository memberRepository;
    //Spring 이 Spring Bean 에 등록된 MemberRepository 를 injection , field injection

    /*@Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //Setter injection */

    /*
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } //Constructor injection, 생성자 인젝션, 가장 추천하는 방식이다. memberRepository 가 만들어지자마자 추가 하는 방식이므로 안전함, 테스트 케이스에도 좋음  */

    /**
     * 회원가입
     **/
    @Transactional
    public Long join(Member member){
        vaildateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicateMember(Member member) {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName()); // 유니크 제약 조건이 제일 안전하다. 동시 가입할 시

        if (! findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    //@Transactional(readOnly = true)
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //@Transactional(readOnly = true)
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }

    //커맨드랑 쿼리를 분리
}
