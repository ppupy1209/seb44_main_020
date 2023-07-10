package com.moovda_project.moovda.module.movie.repository;

import com.moovda_project.moovda.module.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
