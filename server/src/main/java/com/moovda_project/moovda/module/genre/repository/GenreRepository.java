package com.moovda_project.moovda.module.genre.repository;

import com.moovda_project.moovda.module.genre.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    Genre findByName(String name);
}
