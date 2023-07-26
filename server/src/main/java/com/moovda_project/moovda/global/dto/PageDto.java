package com.moovda_project.moovda.global.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PageDto {
    int currentPage;
    int pageSize;
    int total;

}
