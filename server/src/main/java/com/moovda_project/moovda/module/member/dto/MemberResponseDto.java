package com.moovda_project.moovda.module.member.dto;

import com.moovda_project.moovda.global.dto.PageDto;
import com.moovda_project.moovda.module.watch.dto.ToWatchResponseDto;
import com.moovda_project.moovda.module.watch.dto.WatchedResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberResponseDto {

    private long memberId;
    private List<ToWatchResponseDto> toWatch;
    private List<WatchedResponseDto> watched;

    private PageDto toWatchInfo;
    private PageDto watchedInfo;
}
