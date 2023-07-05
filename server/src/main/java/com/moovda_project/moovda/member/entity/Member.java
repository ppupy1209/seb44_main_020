package com.moovda_project.moovda.member.entity;

import com.moovda_project.moovda.audit.Auditable;
import com.moovda_project.moovda.movie.entity.ToWatch;
import com.moovda_project.moovda.movie.entity.Watched;
import com.moovda_project.moovda.question.entity.Question;
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
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(nullable = false)
    private String nickname;

    @OneToMany(mappedBy = "member")
    private List<ToWatch> toWatchList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private  List<Watched> watchedList = new ArrayList<>();

}
