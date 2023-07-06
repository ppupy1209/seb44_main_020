package com.moovda_project.moovda.movie.repository;

import com.moovda_project.moovda.movie.entity.Watched;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchedRepository extends JpaRepository<Watched,Long> {
}
