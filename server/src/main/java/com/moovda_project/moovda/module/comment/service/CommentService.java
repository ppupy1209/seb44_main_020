package com.moovda_project.moovda.module.comment.service;

import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.comment.repository.CommentRepository;
import com.moovda_project.moovda.global.exception.BusinessLogicException;
import com.moovda_project.moovda.global.exception.ExceptionCode;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.member.service.MemberService;
import com.moovda_project.moovda.module.movie.entity.Movie;
import com.moovda_project.moovda.module.movie.entity.watch.Watched;
import com.moovda_project.moovda.module.movie.service.MovieService;
import com.moovda_project.moovda.module.movie.service.watch.WatchedService;
import lombok.RequiredArgsConstructor;
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
    public Comment createComment(Comment comment, long movieId, long memberId) {
        updateStarAvg(comment,movieId);

        addWatched(comment,movieId,memberId);

        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment,long memberId,long movieId) {
       Comment findComment = findVerifiedComment(comment.getCommentId());

       checkValidatedMember(memberId,findComment);

       Optional.ofNullable(comment.getContent())
               .ifPresent(content -> findComment.setContent(content));
       Optional.ofNullable(comment.getStar())
               .ifPresent(star -> findComment.setStar(star));

       updateStarAvg(findComment,movieId);

       return commentRepository.save(findComment);
    }


    public void deleteComment(long commentId,long memberId) {

        Comment comment = findVerifiedComment(commentId);

        checkValidatedMember(memberId,comment);

        deleteWatched(commentId);

        commentRepository.delete(comment);
    }


    public Comment findVerifiedComment(long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        Comment findComment = optionalComment.orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));

        return findComment;
    }

    private void updateStarAvg(Comment comment, long movieId) {
        Movie movie = movieService.findMovie(movieId);

        float newStar = comment.getStar();
        float totalStar = calculateTotalStar(movie);

        totalStar += newStar;

        float averageStar = totalStar / (movie.getComments().size()+1);

        float roundedStar = Math.round(averageStar * 10) / 10.0f;

        movie.setStarAvg(roundedStar);

        comment.setMovie(movie);

        movieService.updateMovie(movie);
    }

    private float calculateTotalStar(Movie movie) {
        List<Comment> comments = movie.getComments();
        float sum = 0.0f;
        for(Comment comment : comments) {
            sum += comment.getStar();
        }
        return sum;
    }

    private void addWatched(Comment comment,long movieId, long memberId) {
        Movie movie = movieService.findMovie(movieId);

        Member member = memberService.findMember(memberId);

        comment.setMember(member);

        Watched watched = new Watched();
        watched.setMovie(movie);
        watched.setMember(member);

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

}
