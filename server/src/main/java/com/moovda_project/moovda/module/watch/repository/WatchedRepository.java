package com.moovda_project.moovda.module.watch.repository;


import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.movie.entity.Movie;
import com.moovda_project.moovda.module.watch.entity.ToWatch;
import com.moovda_project.moovda.module.watch.entity.Watched;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WatchedRepository extends JpaRepository<Watched,Long> {
    Optional<Watched> findByMemberAndMovie(Member member, Movie movie);
}
