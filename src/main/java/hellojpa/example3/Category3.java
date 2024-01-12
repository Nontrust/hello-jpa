package hellojpa.example3;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category3 {
    @Id @GeneratedValue @Column(name = "category3_id")
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name =  "parent_id")
    private Category3 parent;

    @OneToMany(mappedBy = "parent")
    private List<Category3> child = new ArrayList<>();
}
