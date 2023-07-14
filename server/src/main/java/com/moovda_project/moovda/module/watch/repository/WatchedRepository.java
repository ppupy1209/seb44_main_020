package com.moovda_project.moovda.module.watch.repository;


import com.moovda_project.moovda.module.watch.entity.Watched;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchedRepository extends JpaRepository<Watched,Long> {
}
