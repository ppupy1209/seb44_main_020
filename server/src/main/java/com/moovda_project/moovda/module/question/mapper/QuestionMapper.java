package com.moovda_project.moovda.module.question.mapper;

import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.question.dto.QuestionDto;
import com.moovda_project.moovda.module.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(source = "memberId", target = "member.memberId")
    Question questionPostDtoToQuestion(QuestionDto.Post questionPostDto);
    @Mapping(source = "authenticatedMemberId", target = "member.memberId")
    Question questionPatchDtoToQuestion(QuestionDto.Patch questionPatchDto);

    List<QuestionDto.Response> questionsToQuestionResponseDtos(List<Question> questions);

    default QuestionDto.Response questionToQuestionResponseDto(Question question) {

        QuestionDto.Response questionResponseDto =
                QuestionDto.Response.builder()
                        .questionId(question.getQuestionId())
//                        .nickname(question.getMember().getNickname())
                        .memberId(question.getMember().getMemberId())
                        .title(question.getTitle())
                        .content(question.getContent())
                        .createdAt(question.getCreatedAt())
                        .modifiedAt(question.getModifiedAt())
                        .answerCount(question.getAnswerCount())
                        .build();
        return questionResponseDto;
    }


}
