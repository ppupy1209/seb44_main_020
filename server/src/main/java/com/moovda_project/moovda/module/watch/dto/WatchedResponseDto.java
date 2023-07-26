package com.moovda_project.moovda.module.watch.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WatchedResponseDto {
    private long movieId;
    private String title;
    private String poster;
    private Double star;

}
