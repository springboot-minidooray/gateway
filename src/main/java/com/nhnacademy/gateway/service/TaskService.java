package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.adaptor.TaskAdaptor;
import com.nhnacademy.gateway.domain.dto.ProjectDto;
import com.nhnacademy.gateway.domain.dto.ProjectListDto;
import com.nhnacademy.gateway.domain.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskAdaptor taskAdaptor;

    public TaskDto getTask(Long projectId, int taskId) {
        return taskAdaptor.getTask(projectId, taskId);
    }
}
