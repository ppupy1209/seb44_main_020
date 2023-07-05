package com.moovda_project.moovda.question.repository;

import com.moovda_project.moovda.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface QuestionRepository extends JpaRepository<Question, Long> {

    // pagenation 사용
    Page<Question> findAll(Pageable pageable);
}
