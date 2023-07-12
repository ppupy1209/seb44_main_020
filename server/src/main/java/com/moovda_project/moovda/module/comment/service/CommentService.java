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
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
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

    public Comment createComment(Comment comment) {

        Member member = memberService.findMember(comment.getMember().getMemberId());
        Movie movie = movieService.findMovie(comment.getMovie().getMovieId());

        existsCommentByMemberAndMovie(movie,member);

 //       movie.addComments(comment);

        Comment createdComment = commentRepository.save(comment);

        updateStarAvg(movie);

        addWatched(movie,member);

        return createdComment;
    }

    public Comment updateComment(Comment comment,long memberId) {
       Comment findComment = findVerifiedComment(comment.getCommentId());

       checkValidatedMember(memberId,findComment);

       findComment.setContent(comment.getContent());
       findComment.setStar(comment.getStar());

       Comment updatedComment = commentRepository.save(findComment);

       Movie movie = movieService.findMovie(findComment.getMovie().getMovieId());
       updateStarAvg(movie);

       return updatedComment;
    }


    public void deleteComment(long commentId,long memberId) {

        Comment comment = findVerifiedComment(commentId);

        checkValidatedMember(memberId,comment);

        deleteWatched(commentId);

        commentRepository.delete(comment);

        Movie movie = movieService.findMovie(comment.getMovie().getMovieId());
        movie.removeComments(comment);
        updateStarAvg(movie);
    }


    public Comment findVerifiedComment(long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        Comment findComment = optionalComment.orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));

        return findComment;
    }

    private void updateStarAvg(Movie movie) {
        double totalStar = calculateTotalStar(movie);

        double averageStar = totalStar / movie.getComments().size();

        double roundedStar = Double.parseDouble(String.format("%.1f", averageStar));

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

    private void addWatched(Movie movie, Member member) {
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

    private void existsCommentByMemberAndMovie(Movie movie, Member member) {
        if(commentRepository.existsByMemberAndMovie(member,movie)) {
            throw new BusinessLogicException(ExceptionCode.COMMENT_EXISTS);
        }
    }

}
