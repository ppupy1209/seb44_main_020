package com.moovda_project.moovda.module.member.mapper;

import com.moovda_project.moovda.module.member.dto.MemberDto;
import com.moovda_project.moovda.module.member.dto.MemberResponseDto;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.global.dto.PageDto;
import com.moovda_project.moovda.module.watch.dto.ToWatchResponseDto;
import com.moovda_project.moovda.module.watch.dto.WatchedResponseDto;
import com.moovda_project.moovda.module.watch.entity.ToWatch;
import com.moovda_project.moovda.module.watch.entity.Watched;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {

    Member memberPostToMember(MemberDto.Post requestBody);

    default MemberResponseDto memberToMemberResponseDto(Member member) {
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.setMemberId(member.getMemberId());

        List<ToWatchResponseDto> toWatchResponseDtos = new ArrayList<>();
        List<ToWatch> toWatchList = member.getToWatchList();
        for(ToWatch toWatch : toWatchList) {
            ToWatchResponseDto toWatchResponseDto = new ToWatchResponseDto();

            long movieId = toWatch.getMovie().getMovieId();
            String title = toWatch.getMovie().getTitle();
            String poster = toWatch.getMovie().getPoster();

            toWatchResponseDto.setMovieId(movieId);
            toWatchResponseDto.setTitle(title);
            toWatchResponseDto.setPoster(poster);

            toWatchResponseDtos.add(toWatchResponseDto);
        }
        memberResponseDto.setToWatch(toWatchResponseDtos);


        List<WatchedResponseDto> watchedResponseDtos = new ArrayList<>();
        List<Watched> watchedList = member.getWatchedList();
        for(Watched watched : watchedList) {
            WatchedResponseDto watchedResponseDto = new WatchedResponseDto();

            watchedResponseDto.setMovieId(watched.getMovie().getMovieId());
            watchedResponseDto.setTitle(watched.getMovie().getTitle());
            watchedResponseDto.setPoster(watched.getMovie().getPoster());
            watchedResponseDto.setStar(watched.getMovie().getComments().get(watched.getWatchedId().intValue()-1).getStar());
            watchedResponseDtos.add(watchedResponseDto);
        }



        memberResponseDto.setWatched(watchedResponseDtos);

        return memberResponseDto;
    }



}
