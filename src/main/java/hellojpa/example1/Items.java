package hellojpa.example1;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(name="item_seq_generator", sequenceName = "item_seq")
public class Items {
    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq_generator")
    private Long id;
    private String name;
    private Integer price;
    private Integer stockQuantity;
}
