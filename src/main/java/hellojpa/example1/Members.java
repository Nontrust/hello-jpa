package hellojpa.example1;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "member_seq_gen", sequenceName = "member_seq")
public class Members {
    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
    private Long id;
    private String memberName;
    private String City;
    private String Street;
    private String ZipCode;

    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;

}
