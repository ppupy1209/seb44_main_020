package com.moovda_project.moovda.module.comment.service;

import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.comment.repository.CommentRepository;
import com.moovda_project.moovda.global.exception.BusinessLogicException;
import com.moovda_project.moovda.global.exception.ExceptionCode;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.member.service.MemberService;
import com.moovda_project.moovda.module.movie.entity.Movie;
import com.moovda_project.moovda.module.watch.entity.Watched;
import com.moovda_project.moovda.module.watch.repository.ToWatchRepository;
import com.moovda_project.moovda.module.movie.service.MovieService;
import com.moovda_project.moovda.module.watch.service.WatchedService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MovieService movieService;
    private final WatchedService watchedService;
    private  final MemberService memberService;
    private final ToWatchRepository toWatchRepository;

    public Comment createComment(Comment comment) {

        Member member = memberService.findVerifiedMember(comment.getMember().getMemberId());
        Movie movie = movieService.findVerifiedMovie(comment.getMovie().getMovieId());

        checkExistsCommentByMemberAndMovie(movie,member);   // 이미 코멘트를 작성했으면, 작성 못해야 함.

        checkExistsToWatchByMemberAndMovie(member,movie);  // 볼 영화 목록에 있으면, 볼 영화 목록에서 삭제

        Comment createdComment = commentRepository.save(comment);

        updateStarAvg(movie);   // 영화 평균 별점 업데이트

        addWatched(movie,member,createdComment);  // 본 영화 목록에 추가

        return createdComment;
    }

    public Comment updateComment(Comment comment,long memberId) {
       Comment findComment = findVerifiedComment(comment.getCommentId()); // 존재하는 코멘트인지 확인

       checkValidatedMember(memberId,findComment);  // 인증된 멤버인지 확인

        Optional.ofNullable(comment.getContent())
                .ifPresent(content -> findComment.setContent(content));
        Optional.ofNullable(comment.getStar())
                .ifPresent(star -> findComment.setStar(star));

       Comment updatedComment = commentRepository.save(findComment);

       Movie movie = movieService.findVerifiedMovie(findComment.getMovie().getMovieId());

       updateStarAvg(movie);  // 평균 별점 업데이트

       updateWatched(updatedComment.getMovie(),updatedComment.getMember(),updatedComment);

       return updatedComment;
    }


    public void deleteComment(long commentId,long memberId) {

        Comment comment = findVerifiedComment(commentId); // 인증된 코멘트인지 확인

        checkValidatedMember(memberId,comment); // 인증된 멤버인지 확인

        deleteWatched(commentId);   // 본 영화 목록에서 삭제

        commentRepository.delete(comment);

        Movie movie = movieService.findVerifiedMovie(comment.getMovie().getMovieId());

        movie.removeComments(comment);

        updateStarAvg(movie);  // 평균 별점 업데이트
    }


    public Comment findVerifiedComment(long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        Comment findComment = optionalComment.orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));

        return findComment;
    }

    private void updateStarAvg(Movie movie) {
        double totalStar = calculateTotalStar(movie); // 총 별점 합
        double roundedStar;

        if(movie.getComments().size()!=0) {

            double averageStar = totalStar / movie.getComments().size(); // 별점 합 / 코멘트 개수

             roundedStar = Double.parseDouble(String.format("%.1f", averageStar)); // 소수점 둘째자리에서 반올림
        }  else {
             roundedStar = 0.0;
        }

            movie.setStarAvg(roundedStar);

            movieService.updateMovie(movie);

    }

    private double calculateTotalStar(Movie movie) {
        List<Comment> comments = movie.getComments();
        double sum = 0.0;
        for(Comment comment : comments) {
            sum += comment.getStar();
        }
        return sum;
    }

    private void addWatched(Movie movie, Member member,Comment comment) {
        Watched watched = new Watched(comment.getStar(),movie,member);

        watchedService.createWatched(watched);
    }

    private void updateWatched(Movie movie,Member member,Comment comment) {
      Watched watched =  watchedService.findByMemberAndMovie(member,movie);

      watched.setStar(comment.getStar());
      watchedService.createWatched(watched);
    }

    private void deleteWatched(long watchedId) {
        watchedService.deleteWatched(watchedId);
    }

    private void checkValidatedMember(long memberId, Comment findComment) {
        if(findComment.getMember().getMemberId()!= memberId) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_UNAUTHORIZED);
        }
    }

    private void checkExistsCommentByMemberAndMovie(Movie movie, Member member) {
        if(commentRepository.existsByMemberAndMovie(member,movie)) {
            throw new BusinessLogicException(ExceptionCode.COMMENT_EXISTS);
        }
    }

    private void checkExistsToWatchByMemberAndMovie(Member member, Movie movie) {
         if(toWatchRepository.findByMemberAndMovie(member,movie).isPresent()) {
             toWatchRepository.deleteByMemberAndMovie(member,movie);
         }
    }

    public Page<Comment> findCommentsByMovie(Movie movie, Pageable pageable) {
        return commentRepository.findByMovie(movie,pageable);
    }
}
