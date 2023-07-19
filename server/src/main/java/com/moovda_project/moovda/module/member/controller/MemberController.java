package com.moovda_project.moovda.module.member.controller;

import com.moovda_project.moovda.module.member.dto.MemberDto;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.member.mapper.MemberMapper;
import com.moovda_project.moovda.module.member.service.MemberService;
import com.moovda_project.moovda.global.utils.UriCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/v11/members")
@Validated
@Slf4j
public class MemberController {
    private final static String MEMBER_DEFAULT_URL = "/v11/members";

    private final MemberService memberService;

    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody) {
        Member member = mapper.memberPostToMember(requestBody);

        Member createdMember = memberService.createMember(member);
        URI location = UriCreator.createUri(MEMBER_DEFAULT_URL, createdMember.getMemberId());

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{member_id}")
    public ResponseEntity getMember(@PathVariable("member_id") @Positive long memberId) {
        Member member = memberService.findMember(memberId);

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(member), HttpStatus.OK);
    }
}
