package com.moovda_project.moovda.movie.repository;

import com.moovda_project.moovda.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
