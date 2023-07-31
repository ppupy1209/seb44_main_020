package com.moovda_project.moovda.global.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PageDto {
    private int currentPage;
    private int pageSize;
    private long total;

}
