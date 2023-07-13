package com.moovda_project.moovda.module.movie.service.watch;

import com.moovda_project.moovda.global.exception.BusinessLogicException;
import com.moovda_project.moovda.global.exception.ExceptionCode;
import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.member.service.MemberService;
import com.moovda_project.moovda.module.movie.entity.Movie;
import com.moovda_project.moovda.module.movie.entity.watch.ToWatch;
import com.moovda_project.moovda.module.movie.repository.watch.ToWatchRepository;
import com.moovda_project.moovda.module.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ToWatchService {
    private final ToWatchRepository toWatchRepository;

    private final MovieService movieService;
    private final MemberService memberService;

    public ToWatch createToWatch(long movieId, long memberId) {
        ToWatch toWatch = new ToWatch();

        Movie movie = movieService.findMovie(movieId);
        Member member = memberService.findMember(memberId);

        toWatch.setMovie(movie);
        toWatch.setMember(member);

        return toWatchRepository.save(toWatch);
    }

    public void deleteToWatch(long toWatchId,long memberId) {
        ToWatch toWatch = findVerifiedToWatch(toWatchId);

        checkValidatedMember(memberId,toWatch);

        toWatchRepository.delete(toWatch);
    }

    private ToWatch findVerifiedToWatch(long toWatchId) {
        Optional<ToWatch> optionalToWatch = toWatchRepository.findById(toWatchId);

        ToWatch toWatch = optionalToWatch.orElseThrow(() -> new BusinessLogicException(ExceptionCode.TOWATCH_NOT_FOUND));

        return toWatch;
    }

    private void checkValidatedMember(long memberId, ToWatch toWatch) {
        if(toWatch.getMember().getMemberId()!= memberId) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_UNAUTHORIZED);
        }
    }
}
