package com.moovda_project.moovda.module.member.mapper;

import com.moovda_project.moovda.module.member.dto.MemberDto;
import com.moovda_project.moovda.module.member.dto.MemberResponseDto;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.movie.dto.PageDto;
import com.moovda_project.moovda.module.watch.dto.ToWatchResponseDto;
import com.moovda_project.moovda.module.watch.dto.WatchedResponseDto;
import com.moovda_project.moovda.module.watch.entity.ToWatch;
import com.moovda_project.moovda.module.watch.entity.Watched;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {

    Member memberPostToMember(MemberDto.Post requestBody);

    default MemberResponseDto memberToMemberResponseDto(Member member,int page1,int page2, int pageSize) {
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
        int totalToWatch = toWatchResponseDtos.size();
        int startIndex = (page1 - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalToWatch);

        List<ToWatchResponseDto> toWatchResponseDtos2 = toWatchResponseDtos.subList(startIndex,endIndex);
        memberResponseDto.setToWatch(toWatchResponseDtos2);

        PageDto toWatchPageInfo = new PageDto();
        toWatchPageInfo.setPageSize(pageSize);
        toWatchPageInfo.setCurrentPage(page1);
        toWatchPageInfo.setTotal(totalToWatch);


        List<WatchedResponseDto> watchedResponseDtos = new ArrayList<>();
        List<Watched> watchedList = member.getWatchedList();
        for(Watched watched : watchedList) {
            WatchedResponseDto watchedResponseDto = new WatchedResponseDto();

            watchedResponseDto.setMovieId(watched.getMovie().getMovieId());
            watchedResponseDto.setTitle(watched.getMovie().getTitle());
            watchedResponseDto.setPoster(watched.getMovie().getPoster());

            watchedResponseDtos.add(watchedResponseDto);
        }

        int totalWatched = watchedResponseDtos.size();
        int startIndex2 = (page2 - 1) * pageSize;
        int endIndex2 = Math.min(startIndex2 + pageSize, totalWatched);

        List<WatchedResponseDto> watchedResponseDtos2 = watchedResponseDtos.subList(startIndex2,endIndex2);
        memberResponseDto.setWatched(watchedResponseDtos2);

        PageDto watchedPageInfo = new PageDto();
        watchedPageInfo.setPageSize(pageSize);
        watchedPageInfo.setCurrentPage(page2);
        watchedPageInfo.setTotal(totalWatched);

        memberResponseDto.setToWatchInfo(toWatchPageInfo);
        memberResponseDto.setWatchedInfo(watchedPageInfo);

        memberResponseDto.setWatched(watchedResponseDtos2);

        return memberResponseDto;
    }


}
