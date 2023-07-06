package com.moovda_project.moovda.movie.repository;

import com.moovda_project.moovda.movie.entity.ToWatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToWatchRepository extends JpaRepository<ToWatch, Long> {
}
