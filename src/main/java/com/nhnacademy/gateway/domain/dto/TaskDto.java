package com.nhnacademy.gateway.domain.dto;

import com.nhnacademy.gateway.domain.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TaskDto {
    private String projectName;
    private String status;
    private String taskManagerId;
    private Long milestoneId;
    private List<TagDto> tags;
    private List<CommentDto> comments;
}
