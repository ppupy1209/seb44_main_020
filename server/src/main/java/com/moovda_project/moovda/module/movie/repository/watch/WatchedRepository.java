package com.moovda_project.moovda.module.movie.repository.watch;

import com.moovda_project.moovda.module.movie.entity.watch.Watched;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchedRepository extends JpaRepository<Watched,Long> {
}
