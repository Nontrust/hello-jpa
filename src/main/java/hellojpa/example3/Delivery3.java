package hellojpa.example3;

import javax.persistence.*;

@Entity
public class Delivery3 {
    @Id @GeneratedValue @Column(name="delevery3_id")
    private Long id;

    private String city;
    private String street;
    private String zipCode;
    private String status;

    @OneToOne(mappedBy = "delivery")
    private Orders3 orders;
}
