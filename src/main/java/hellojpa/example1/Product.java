package hellojpa.example1;

import hellojpa.entity.MemberProduct;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id @GeneratedValue @Column(name = "product_id")
    Long id;
    String productName;
    int quantity;

    @OneToMany(mappedBy = "products")
    private List<MemberProduct> memberProducts = new ArrayList<>();
}
