package com.moovda_project.moovda.global.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDto {
    int currentPage;
    int pageSize;
    int total;

}
