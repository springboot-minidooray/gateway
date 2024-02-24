package com.nhnacademy.gateway.adaptor;

import com.nhnacademy.gateway.domain.dto.TaskDto;

public interface TaskAdaptor {
    TaskDto getTask(Long projectId, int taskId);
}
