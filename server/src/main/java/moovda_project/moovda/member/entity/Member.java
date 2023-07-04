package moovda_project.moovda.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member-id")
    private Long memberId;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, updatable = false,unique = true)
    private String email;

//    @OneToMany(mappedBy = "member")
//    private List<Question> questionList = new ArrayList<>();
}
