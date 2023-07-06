package com.moovda_project.moovda.question.mapper;

import com.moovda_project.moovda.question.dto.QuestionDto;
import com.moovda_project.moovda.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
//    @Mapping(source = "member_id", target = "member.memberId")
//    Question QuestionPostDtoToQuestion(QuestionDto.Post post);

    Question QuestionPatchDtoToQuestion(QuestionDto.Patch patch);
}
