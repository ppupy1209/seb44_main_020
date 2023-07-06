package com.moovda_project.moovda.movie.entity.genre;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    Genre findByName(String name);
}
