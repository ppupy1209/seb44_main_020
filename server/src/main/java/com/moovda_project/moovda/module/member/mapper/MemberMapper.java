package com.moovda_project.moovda.module.member.mapper;

import com.moovda_project.moovda.module.member.dto.MemberDto;
import com.moovda_project.moovda.module.member.dto.MemberResponseDto;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.watch.dto.ToWatchResponseDto;
import com.moovda_project.moovda.module.watch.dto.WatchedResponseDto;
import com.moovda_project.moovda.module.watch.entity.ToWatch;
import com.moovda_project.moovda.module.watch.entity.Watched;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {

    Member memberPostToMember(MemberDto.Post requestBody);

    default MemberResponseDto memberToMemberResponseDto(Member member) {

        List<ToWatch> toWatchList = member.getToWatchList();
        List<ToWatchResponseDto> toWatchResponseDtos = getToWatchResponseDtos(toWatchList);

        List<Watched> watchedList = member.getWatchedList();
        List<WatchedResponseDto> watchedResponseDtos = getWatchedResponseDtos(watchedList);


        return MemberResponseDto.builder().
                memberId(member.getMemberId()).
                toWatch(toWatchResponseDtos).
                watched(watchedResponseDtos).
                build();
    }

    private List<WatchedResponseDto> getWatchedResponseDtos(List<Watched> watchedList) {
        List<WatchedResponseDto> watchedResponseDtos = watchedList.stream()
                .map(watched -> WatchedResponseDto.builder()
                        .movieId(watched.getMovie().getMovieId())
                        .title(watched.getMovie().getTitle())
                        .poster(watched.getMovie().getPoster())
                        .star(watched.getMovie().getComments().get(watched.getWatchedId().intValue()-1).getStar())
                        .build()).collect(Collectors.toList());
        return watchedResponseDtos;
    }

    private List<ToWatchResponseDto> getToWatchResponseDtos(List<ToWatch> toWatchList) {
        List<ToWatchResponseDto> toWatchResponseDtos = toWatchList.stream()
                .map(toWatch -> ToWatchResponseDto.builder()
                         .movieId(toWatch.getMovie().getMovieId())
                         .title(toWatch.getMovie().getTitle())
                         .poster(toWatch.getMovie().getPoster())
                         .build()).collect(Collectors.toList());
        return toWatchResponseDtos;
    }
}
