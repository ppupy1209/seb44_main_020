package com.moovda_project.moovda.module.watch.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToWatchResponseDto {
    private long movieId;
    private String title;
    private String poster;
}
