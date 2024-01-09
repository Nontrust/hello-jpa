package hellojpa;

import hellojpa.entity.Member;
import hellojpa.example1.Items;
import hellojpa.example1.Members;
import hellojpa.example1.Orders;
import hellojpa.example1.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //persistence.xml -> <persistence-unit name="hello">
        //애플리케이션 로딩 시점에 하나만 만들어야됨
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");

        //트랜잭션 단위 내에 매니저 생성
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /*code*/
        //트랜잭션 생성
        EntityTransaction transaction = entityManager.getTransaction();
        //트랜잭션 시작
        transaction.begin();
        try {
//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("회원");
//
//            //영속
//            entityManager.persist(member);

            Member findMember = entityManager.find(Member.class, 100L);
            Orders order = entityManager.find(Orders.class, 100L);
            Items item = entityManager.find(Items.class, 100L);
            Members members = entityManager.find(Members.class, 100L);
            OrderItem orderItem = entityManager.find(OrderItem.class, 100L);
            //준영속
//            entityManager.detach(member);
            //삭제제
//           entityManager.remove();


            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
