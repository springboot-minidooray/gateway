package com.nhnacademy.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
public class Task {
    private int taskId;
    private long projectId;
    private long milestoneId;
    private String subject;
    private String contents;
    private List<Tag> tagList;
}
