package com.moovda_project.moovda.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PageInfo {

    /**
     *  page : 현재 몇 페이지인지
     *  size : 한 페이지당 데이터가 몇 개 있는지
     *  totalElements : 전체 데이터 개수
     *  totalPages : 전체 페이지 개수
     */

    private int page;
    private int size = 10;
    private long totalElements;
    private int totalPages;
}