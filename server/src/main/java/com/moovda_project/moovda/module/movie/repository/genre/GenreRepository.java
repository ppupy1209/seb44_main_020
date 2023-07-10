package com.moovda_project.moovda.module.movie.repository.genre;

import com.moovda_project.moovda.module.movie.entity.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    Genre findByName(String name);
}
