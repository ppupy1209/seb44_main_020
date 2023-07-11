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

        Member member = memberService.findMember(memberId);
        Movie movie = movieService.findMovie(movieId);

        existsCommentByMemberAndMovie(movie,member);

        updateStarAvg(comment,movie);

        addWatched(movie,member);

        Comment createdComment = commentRepository.save(comment);

        return createdComment;
    }

    public Comment updateComment(Comment comment,long memberId,long movieId) {
       Comment findComment = findVerifiedComment(comment.getCommentId());

       Movie movie = movieService.findMovie(movieId);

       checkValidatedMember(memberId,findComment);

       findComment.setContent(comment.getContent());
       findComment.setStar(comment.getStar());
       updateStarAvg(findComment,movie);

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

    private void updateStarAvg(Comment comment, Movie movie) {
        double newStar = comment.getStar();
        double totalStar = calculateTotalStar(movie);

        totalStar += newStar;

        double averageStar = totalStar / (movie.getComments().size()+1);

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
