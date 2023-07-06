package com.moovda_project.moovda.question.controller;

import com.moovda_project.moovda.question.dto.QuestionDto;
import com.moovda_project.moovda.question.entity.Question;
import com.moovda_project.moovda.question.service.QuestionService;
import com.moovda_project.moovda.question.mapper.QuestionMapper;
import com.moovda_project.moovda.question.repository.QuestionRepository;
import com.moovda_project.moovda.utils.UriCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@Slf4j
@RequestMapping("/questions")
public class QuestionController {

    public final QuestionRepository questionRepository;
    public final QuestionMapper questionMapper;
    public final QuestionService questionService;

    public QuestionController(QuestionRepository questionRepository,QuestionMapper questionMapper,QuestionService questionService) {
        this.questionMapper = questionMapper;
        this.questionRepository = questionRepository;
        this.questionService = questionService;
    }

    /** 질문 등록 **/
//    @PostMapping
//    public ResponseEntity postQuestion(@RequestBody QuestionDto.Post post) {
//        Question createdQuestion = questionService.createQuestion(questionMapper.QuestionPostDtoToQuestion(post));
//
//        URI location = UriCreator.createUri("/questions", createdQuestion.getQuestionId());
//
//        return ResponseEntity.created(location).build();
//    }

    /** 질문 수정 **/
    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") @Positive long questionId,
                                        @RequestBody QuestionDto.Patch patch) {
        // TODO : token으로 어떤 회원인지 알아야 함
        patch.addQuestionId(questionId);

        Question question = questionService.updateQuestion(questionMapper.QuestionPatchDtoToQuestion(patch));

        return ResponseEntity.ok().build();
    }

    /** 질문 삭제 **/
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") @Positive long questionId) {
        questionService.deleteQuestion(questionId);

        return ResponseEntity.noContent().build();
    }
}
