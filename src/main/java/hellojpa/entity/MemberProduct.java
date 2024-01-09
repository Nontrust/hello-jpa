package hellojpa.entity;

import hellojpa.example1.Product;

import javax.persistence.*;

@Entity
public class MemberProduct {
    @Id @GeneratedValue
    Long id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product products;
}
