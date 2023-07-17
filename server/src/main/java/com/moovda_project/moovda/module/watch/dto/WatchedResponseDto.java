package com.moovda_project.moovda.module.watch.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WatchedResponseDto {
    private long movieId;
    private String title;
    private String poster;

    private Double star;

}
