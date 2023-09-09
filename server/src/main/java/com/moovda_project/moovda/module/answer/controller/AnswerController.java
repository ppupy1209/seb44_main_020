package com.moovda_project.moovda.module.answer.controller;

import com.moovda_project.moovda.global.utils.MemberIdExtractor;
import com.moovda_project.moovda.module.answer.dto.AnswerDto;
import com.moovda_project.moovda.module.answer.entity.Answer;
import com.moovda_project.moovda.module.answer.mapper.AnswerMapper;
import com.moovda_project.moovda.module.answer.service.AnswerService;
import com.moovda_project.moovda.global.utils.UriCreator;
import com.moovda_project.moovda.module.movie.entity.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("questions/{question-id}/answers")
@Validated
public class AnswerController {
    private final static String ANSWER_DEFAULT_URL = "/questions/{question-id}/answers";
    private final AnswerMapper answerMapper;
    private final AnswerService answerService;

    public AnswerController(AnswerMapper answerMapper,AnswerService answerService) {
        this.answerMapper = answerMapper;
        this.answerService = answerService;
    }

    @PostMapping
    public ResponseEntity postAnswer(@Valid @RequestBody AnswerDto.Post request,
                                     @Positive @PathVariable("question-id") long questionId) {
        request.setQuestionId(questionId);
        Answer createdAnswer = answerService.createAnswer(answerMapper.answerPostToAnswer(request));

        URI location = UriCreator.createUri("/answers", createdAnswer.getAnswerId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@Valid @RequestBody AnswerDto.Patch request,
                                      @Positive @PathVariable("answer-id") long answerId) {
        long authenticatedMemberId = MemberIdExtractor.extractMemberId();

        request.setAnswerId(answerId);

        request.addAuthenticatedMemberId(authenticatedMemberId);

        answerService.updateAnswer(answerMapper.answerPatchToAnswer(request),authenticatedMemberId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(@Positive @PathVariable("answer-id") long answerId) {
        long authenticatedMemberId = MemberIdExtractor.extractMemberId();

        answerService.deleteAnswer(answerId, authenticatedMemberId);

        return ResponseEntity.noContent().build();
    }

}
