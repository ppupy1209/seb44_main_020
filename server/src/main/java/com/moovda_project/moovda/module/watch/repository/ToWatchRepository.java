package com.moovda_project.moovda.module.watch.repository;

import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.movie.entity.Movie;
import com.moovda_project.moovda.module.watch.entity.ToWatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToWatchRepository extends JpaRepository<ToWatch, Long> {
    Optional<ToWatch> findByMemberAndMovie(Member member, Movie movie);

    void deleteByMemberAndMovie(Member member, Movie movie);
}
