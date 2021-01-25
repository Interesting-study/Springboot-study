package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name); //if i have no return, i prefer to use Optional (to wrap my no return value = null)
    List<Member> findAll();

    //Optional<Member> findByName(String name);

    //Optional<Member> findByName(String name);
}
