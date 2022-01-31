package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
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

            /*
            Member member1 = new Member();
            member1.setId(250L);
            member1.setUsername("member250");
            member1.setRoleType(RoleType.USER);

            Member member2 = new Member();
            member2.setId(251L);
            member2.setUsername("member210");
            member2.setRoleType(RoleType.ADMIN);

            em.persist(member1);
            em.persist(member2);
             */

            /*
            Member member = new Member();
            member.setUsername("abc");

            System.out.println("============");
            em.persist(member);
            System.out.println(member.getId());
            System.out.println("============");
             */

            /*
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("memberA");
            member.setTeamId(team.getId());
            em.persist(member);

            Member findMember = em.find(Member.class, member.getId());
            Long findTeamId = findMember.getTeamId();
            Team findTeam = em.find(Team.class, findTeamId);
             */

            /*
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("memberA");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();

            List<Member> members = findTeam.getMembers();
            for (Member m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }
             */

            /*
            Team team = new Team();
            team.setName("teamA");
            em.persist(team); //select

            System.out.println("====");

            Member member = new Member();
            member.setUsername("memberA");
            member.changeTeam(team);
            em.persist(member); // select

            System.out.println("====");

            Team findTeam = em.find(Team.class, team.getId());
//            findTeam.getMembers().add(member);

            System.out.println("====");
            List<Member> members = findTeam.getMembers();
            for (Member m : members) {
                System.out.println("member = " + m);
            }
            System.out.println("====");
             */

            /*
            Member member = new Member();
            member.setUsername("member1");

            em.persist(member);

            Team team = new Team();
            team.setName("teamA");

            team.getMembers().add(member);

            em.persist(team);
             */

            /*
            Movie movie = new Movie();
            movie.setDirector("감독");
            movie.setActor("배우");
            movie.setName("영화제묵");
            movie.setPrice(1000);

            em.persist(movie);

            em.flush();
            em.clear();

//            Movie movie1 = em.find(Movie.class, movie.getId());
//            System.out.println("movie1 = " + movie1);

            Item item = em.find(Item.class, movie.getName());
            System.out.println("item = " + item);
             */

            Member member = new Member();
            member.setUsername("user1");
            member.setCreatedBy("kim");
            member.setCreatedDate(LocalDateTime.now());

            em.persist(member);

            em.flush();
            em.clear();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
