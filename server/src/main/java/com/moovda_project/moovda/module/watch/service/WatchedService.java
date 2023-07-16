package com.moovda_project.moovda.module.watch.service;

import com.moovda_project.moovda.global.exception.BusinessLogicException;
import com.moovda_project.moovda.global.exception.ExceptionCode;
import com.moovda_project.moovda.module.watch.entity.Watched;
import com.moovda_project.moovda.module.watch.repository.WatchedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class WatchedService {

    private final WatchedRepository watchedRepository;

    public Watched createWatched(Watched watched) {
      return watchedRepository.save(watched);
    }

    public void deleteWatched(long watchedId) {
         Watched watched = findVerifiedWatched(watchedId); // watched 가 있어야 삭제 가능

         watchedRepository.delete(watched);
    }

    @Transactional(readOnly = true)
    private Watched findVerifiedWatched(long watchedId) {
        Optional<Watched> watched = watchedRepository.findById(watchedId);

        Watched findWatched = watched.orElseThrow(() -> new BusinessLogicException(ExceptionCode.WATCHED_NOT_FOUND));

        return findWatched;
    }

}
