package hellojpa.example1;

import hellojpa.example1.enums.OrdersStatus;
import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(name = "orders_seq_gen", sequenceName = "orders_seq")
public class Orders {
    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq_gen")
    private Long id;

    @Timestamp
    private LocalDate orderDate;
    @Enumerated(EnumType.STRING)
    private OrdersStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Members orderMember;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();


    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

}
