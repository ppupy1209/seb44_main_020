package com.moovda_project.moovda.module.member.mapper;

import com.moovda_project.moovda.module.member.dto.MemberDto;
import com.moovda_project.moovda.module.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {

    Member memberPostToMember(MemberDto.Post requestBody);
}
