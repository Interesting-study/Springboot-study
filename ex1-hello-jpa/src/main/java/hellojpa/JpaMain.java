package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        try {
        //  비영속
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("helloB");
//        //트랜잭션이 매우 중요함
//            영속
//            em.persist(member);
//            tx.commit();
//        } catch (Exception e){
//            tx.rollback();
//        } finally {
//            em.close();
//        } //정석코드의 예
//        try {
//            Member findMember = em.find(Member.class, 1L);
////            System.out.println("findMember.id = " + findMember.getId());
////            System.out.println("findMember.name = " + findMember.getName());
//
//            findMember.setName("OtterA");
//
//            tx.commit();
//        } catch (Exception e){
//            tx.rollback();
//        } finally {
//            em.close();
//        } //정석코드의 예

//        try {
//            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }
//
//            tx.commit();
//        } catch (Exception e){
//            tx.rollback();
//        } finally {
//            em.close();
//        } //정석코드의 예

//        try {
//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//
//            tx.commit();
//        } catch (Exception e){
//            tx.rollback();
//        } finally {
//            em.close();
//        } //정석코드의 예

//        try {
////            Member member1 = new Member(150L, "A");
////            Member member2 = new Member(160L, "B");
//
////            em.persist(member1);
////            em.persist(member2);
//
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");
//            System.out.println("======================");
//
//            tx.commit();
//        } catch (Exception e){
//            tx.rollback();
//        } finally {
//            em.close();
//        } //정석코드의 예

//        try {
//
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush();
//
//            System.out.println("======================");
//
//            tx.commit();
//        } catch (Exception e){
//            tx.rollback();
//        } finally {
//            em.close();
//        } //정석코드의 예

        try {
            Member member = new Member();
            //member.setId("ID_A");
            member.setUsername("C");

            em.persist(member);

            em.flush();

            System.out.println("======================");

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        } //정석코드의 예

        emf.close();

    }
}
