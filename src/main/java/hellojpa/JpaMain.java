package hellojpa;

import hellojpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //persistence.xml -> <persistence-unit name="hello">
        //애플리케이션 로딩 시점에 하나만 만들어야됨
        EntityManagerFactory helloEntityManagerFactory = Persistence.createEntityManagerFactory("test");

        //트랜잭션 단위 내에 매니저 생성
        EntityManager entityManager = helloEntityManagerFactory.createEntityManager();

        /*code*/
        //트랜잭션 생성
        EntityTransaction transaction = entityManager.getTransaction();
        //트랜잭션 시작
        transaction.begin();
        try {
            List<Member> result = entityManager.createQuery("select M from Member as M", Member.class)
                    //pagination
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();
            for (Member member : result) {
                
            }
//            Member findMember = entityManager.find(Member.class, 1L);
            //수정 (persist 할 필요 없음) -> 자동 Update
//            findMember.setName("HelloJPA");

            //삭제
            //entityManager.remove(findMember);

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            entityManager.close();
        }

        helloEntityManagerFactory.close();
    }
}
