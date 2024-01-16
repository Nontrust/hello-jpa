package hellojpa.inheritance;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Item extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String name;
    private Long price;

}
