package hellojpa.example3;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Orders3 {
    @Id @GeneratedValue @Column(name = "order3_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member3_id")
    private Member3 member;

    @OneToOne
    @JoinColumn(name = "delivery3_id")
    private Delivery3 delivery;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    private String status;


}
