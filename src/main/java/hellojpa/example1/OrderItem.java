package hellojpa.example1;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="order_item_seq_generator", sequenceName = "order_item_seq")
public class OrderItem {
    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_seq_generator")
    private long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Items item;

    private Integer orderPrice;
    private Integer count;

    public void setOrder(Orders order) {
        this.order = order;
    }
}
