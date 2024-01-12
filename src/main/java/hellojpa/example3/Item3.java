package hellojpa.example3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item3 {
    @Id @GeneratedValue @Column(name="item3_id")
    private Long id;
    private String name;
    private Long price;
    private int stockQuantity;
}
