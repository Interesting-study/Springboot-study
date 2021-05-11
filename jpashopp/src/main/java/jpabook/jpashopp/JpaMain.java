package jpabook.jpashopp;

import jpabook.jpashopp.domain.Member;
import jpabook.jpashopp.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();

            Member member = em.find(Member.class, memberId);

            Member findMember = order.getMember();

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        } //정석코드의 예

        emf.close();
    }

}
