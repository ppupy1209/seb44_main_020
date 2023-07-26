package com.moovda_project.moovda.module.comment.repository;

import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    boolean existsByMemberAndMovie(Member member, Movie movie);
}
