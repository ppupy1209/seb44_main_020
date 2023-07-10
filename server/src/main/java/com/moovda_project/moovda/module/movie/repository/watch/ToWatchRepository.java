package com.moovda_project.moovda.module.movie.repository.watch;

import com.moovda_project.moovda.module.movie.entity.watch.ToWatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToWatchRepository extends JpaRepository<ToWatch, Long> {
}
