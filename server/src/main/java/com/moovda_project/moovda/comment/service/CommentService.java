package com.moovda_project.moovda.comment.service;

import com.moovda_project.moovda.comment.entity.Comment;
import com.moovda_project.moovda.comment.repository.CommentRepository;
import com.moovda_project.moovda.exception.BusinessLogicException;
import com.moovda_project.moovda.exception.ExceptionCode;
import com.moovda_project.moovda.movie.entity.Movie;
import com.moovda_project.moovda.movie.entity.Watched;
import com.moovda_project.moovda.movie.service.MovieService;
import com.moovda_project.moovda.movie.service.WatchedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MovieService movieService;
    private final WatchedService watchedService;
    public Comment createComment(Comment comment) {
        updateStarAvg(comment);

        addWatched(comment);

        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
       Comment findComment = findVerifiedComment(comment.getCommentId());

       Optional.ofNullable(comment.getContent())
               .ifPresent(content -> findComment.setContent(content));
       Optional.ofNullable(comment.getStar())
               .ifPresent(star -> findComment.setStar(star));

       updateStarAvg(findComment);

       return commentRepository.save(findComment);
    }


//    public Page<Comment> findComments {
//
//    }

     public void deleteComment(long commentId) {
        Comment comment = findVerifiedComment(commentId);

        deleteWatched(comment);

        commentRepository.delete(comment);
     }


    private Comment findVerifiedComment(long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        Comment findComment = optionalComment.orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));

        return findComment;
    }

    private void updateStarAvg(Comment comment) {
        Movie movie = movieService.findMovie(comment.getMovie().getMovieId());

        float newStar = comment.getStar();
        float totalStar = movie.getStarAvg() * movie.getComments().size();

        totalStar += newStar;
        float averageStar = totalStar / (movie.getComments().size()+1);

        float roundedStar = Math.round(averageStar * 10) / 10.0f;

        movie.setStarAvg(roundedStar);

        movieService.updateMovie(movie);
    }

    private void addWatched(Comment comment) {
        Watched watched = new Watched();
        watched.setMovie(comment.getMovie());
        watched.setMember(comment.getMember());

        watchedService.createWatched(watched);
    }

    private void deleteWatched(Comment comment) {
        Watched watched = new Watched();
        watched.setMember(comment.getMember());

        watchedService.deleteWatched(watched.getWatchedId());
    }
}
