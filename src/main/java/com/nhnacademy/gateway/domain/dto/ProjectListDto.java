package com.nhnacademy.gateway.domain.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class ProjectListDto {
    private Long projectId;
    private String projectName;
    private String projectManagerId;
    private String status;
}
