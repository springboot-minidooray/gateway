package com.nhnacademy.gateway.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProjectDto {
    private String projectName;
    private String projectManagerId;
    private List<TaskDto> tasks;
    private String status;
}
