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

        try {
            /*
            // 비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJpa");

            // 영속
            System.out.println("==== BEFORE ====");
            em.persist(member);
            System.out.println("==== START ====");

            Member findMember = em.find(Member.class, 101L);
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());
             */

            /*
            Member member1 = em.find(Member.class, 101L);
            Member member2 = em.find(Member.class, 101L);

            System.out.println(member1 == member2);
             */

            /*
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);

            System.out.println("============");
             */

            /*
            Member member = em.find(Member.class, 150L);
            member.setName("asdf");

            System.out.println("============");
             */

            /*
            Member member = new Member(200L, "member200");

            em.persist(member);

            em.flush();

            System.out.println("============");
             */

            /*
            Member member = em.find(Member.class, 150L);
            member.setName("abcd");

            // em.detach(member);
            em.clear();

            Member member2 = em.find(Member.class, 150L);

            System.out.println("============");
             */

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
