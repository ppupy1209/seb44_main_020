package com.moovda_project.moovda.comment.repository;

import com.moovda_project.moovda.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
