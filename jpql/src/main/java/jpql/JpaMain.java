package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            TypedQuery<Member> query = em.createQuery("select m From Member m", Member.class);
            List<Member> resultList = query.getResultList();

            for (Member member1 : resultList) {
                System.out.println("member1 = " + member1);
            }
            //  타입은 엔티티만
//            TypedQuery<String> query2 = em.createQuery("select m.username From Member m", String.class);
//            Query query3 = em.createQuery("select m.username, m.age From Member m");

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        } //정석코드의 예

        emf.close();
    }

}
