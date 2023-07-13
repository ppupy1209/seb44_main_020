package com.moovda_project.moovda.module.answer.mapper;

import com.moovda_project.moovda.module.answer.dto.AnswerDto;
import com.moovda_project.moovda.module.answer.entity.Answer;
import com.moovda_project.moovda.module.question.service.QuestionService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    /*
    default Answer answerPostToAnswer(long questionId, QuestionService questionService, AnswerDto.Post requesBody) {
        Answer answer = new Answer();
        answer.setContent(requesBody.getContent());
      //  answer.setMovie(requesBody.getMovie());
        answer.setQuestion(questionService.findVerifiedQuestion(questionId));
        return answer;
    }


     */
    @Mapping(source = "memberId", target = "member.memberId")
    @Mapping(source = "questionId", target = "question.questionId")
    Answer answerPostToAnswer(AnswerDto.Post answerPostDto);

    @Mapping(source = "authenticatedMemberId", target = "member.memberId")
    Answer answerPatchToAnswer(AnswerDto.Patch answerPatchDto);

    AnswerDto.Response answerToAnswerResponse(Answer answer);

    List<AnswerDto.Response> answersToAnswerResponses(List<Answer> answers);
}
