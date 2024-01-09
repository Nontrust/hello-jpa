package hellojpa.entity;



import hellojpa.example1.MemberProduct;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
//@Table(uniqueConstraints =
//        {@UniqueConstraint(name = "NAME_AGE_UNIQUE", columnNames = {"NAME","AGE"})}
//)

// allocationSize = 50 -> next call 메모리에 50개 올림 (was 오류시 메모리 날라감)
@SequenceGenerator(name="member_seq_generator", sequenceName = "member_seq")
public class Member {
    @Id
    // sequence의 다음 값만 불러옴
    // entity manager가 영속성을 얻은 시점에 바로 insert문 날림 -> 벌크 인서트에 불리할듯?
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    @Column(name = "member_id")
    private Long id;
    @Column(name ="name", updatable = false, nullable = false, unique = true)
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Lob
    private String description;

    @Transient
    private int temp;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProduct = new ArrayList<>();

    public Member(){}

}
