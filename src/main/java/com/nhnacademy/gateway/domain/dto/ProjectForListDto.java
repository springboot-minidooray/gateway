package com.nhnacademy.gateway.domain.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class ProjectForListDto {
    private String projectName;
    private String projectManagerId;
    private String status;
}
