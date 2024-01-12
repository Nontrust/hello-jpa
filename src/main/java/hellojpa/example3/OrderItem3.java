package hellojpa.example3;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderItem3 {
    @Id @GeneratedValue @Column(name = "order_item3_id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "order3_id")
    private Orders3 orders;
    @OneToMany
    private List<Item3> items = new ArrayList<>();

    private Long orderPrice;
    private int count;
}
