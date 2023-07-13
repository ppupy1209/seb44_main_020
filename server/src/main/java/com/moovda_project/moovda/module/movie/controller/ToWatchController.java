package com.moovda_project.moovda.module.movie.controller;

import com.moovda_project.moovda.global.auth.utils.MemberIdExtractor;
import com.moovda_project.moovda.global.utils.UriCreator;
import com.moovda_project.moovda.module.movie.entity.watch.ToWatch;
import com.moovda_project.moovda.module.movie.service.watch.ToWatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/toWatch")
@RequiredArgsConstructor
@Validated
public class ToWatchController {

    private final static String TOWATCH_DEFAULT_URL = "/toWatch";
    private final ToWatchService toWatchService;

    @PostMapping("/{movie_id}")
    public ResponseEntity postToWatch(@PathVariable("movie_id") @Positive long movieId) {
        long memberId = MemberIdExtractor.extractMemberId();

        ToWatch toWatch = toWatchService.createToWatch(movieId,memberId);

        URI location = UriCreator.createUri(TOWATCH_DEFAULT_URL,toWatch.getToWatchId());

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{movie_id}")
    public ResponseEntity deleteToWatch(@PathVariable("movie_id") @Positive long movieId) {
        long memberId = MemberIdExtractor.extractMemberId();

        toWatchService.deleteToWatch(movieId,memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
