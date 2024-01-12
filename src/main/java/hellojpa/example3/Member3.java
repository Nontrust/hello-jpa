package hellojpa.example3;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "member3_seq_gen", sequenceName = "member3_seq")
public class Member3 {
    @Id @GeneratedValue @Column(name = "member3_id")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipCode;

}
