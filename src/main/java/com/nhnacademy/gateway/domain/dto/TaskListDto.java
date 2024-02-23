package com.nhnacademy.gateway.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskListDto {
    private String taskId;
    private String subject;
    private String status;
    private String projectManagerId;
}
