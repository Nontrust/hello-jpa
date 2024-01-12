package hellojpa.example3;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoryItem3 {
    @Id @GeneratedValue
    @Column(name = "category_item3_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category3_id")
    private Category3 category;

    @OneToMany
    private List<Item3> items = new ArrayList<>();

}
