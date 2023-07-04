package com.moovda_project.moovda.like.entity;

import com.moovda_project.moovda.comment.entity.Comment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(name = "likes")
public class like {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "like_id")
     private Long likeId;

     @Column(name = "like_status")
     private boolean likeStatus = false;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "comment_id")
     private Comment comment;
}
