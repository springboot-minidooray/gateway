package com.nhnacademy.gateway.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskForListDto {
    private String taskId;
    private String projectName;
    private String status;
    private String projectManagerId;
}
