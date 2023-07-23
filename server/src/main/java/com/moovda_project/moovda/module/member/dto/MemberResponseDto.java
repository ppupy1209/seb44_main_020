package com.moovda_project.moovda.module.member.dto;


import com.moovda_project.moovda.module.watch.dto.ToWatchResponseDto;
import com.moovda_project.moovda.module.watch.dto.WatchedResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MemberResponseDto {
    private long memberId;
    private String nickname;
    private List<ToWatchResponseDto> toWatch;
    private List<WatchedResponseDto> watched;

}
