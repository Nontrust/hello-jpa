package hellojpa;

import hellojpa.inheritance.Album;

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
            Album album = entityManager.getReference(Album.class, 1L);

            album.getArtist();

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
