package com.moovda_project.moovda.module.member.entity;

import com.moovda_project.moovda.global.audit.Auditable;

import com.moovda_project.moovda.module.watch.entity.ToWatch;
import com.moovda_project.moovda.module.watch.entity.Watched;
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
    @Column(nullable = false, updatable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

//    @Column(nullable = false)
//    private String nickname;

    @OneToMany(mappedBy = "member",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<ToWatch> toWatchList = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Watched> watchedList = new ArrayList<>();

//    public Member(String nickname) {
//        this.nickname = nickname;
//    }


    public void addToWatchList(ToWatch toWatch) {
        this.toWatchList.add(toWatch);
        if(toWatch.getMember()!=this) {
            toWatch.setMember(this);
        }
    }

    public void addWatchedList(Watched watched) {
        this.watchedList.add(watched);
        if(watched.getMember()!=this) {
            watched.setMember(this);
        }
    }
}
