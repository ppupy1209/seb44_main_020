package com.moovda_project.moovda.module.movie.dto.staff;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Builder
public class StaffResponseDto {
    String role;
    String position;
    String name;
}
