package jpabook.jpashop.repository;


import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(String name);
}
