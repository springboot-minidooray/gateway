package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.domain.dto.TaskDto;
import com.nhnacademy.gateway.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/project/{projectId}/tasks/{taskId}")
    public String getProject(@PathVariable Long projectId, @PathVariable int taskId, Model model) {
        TaskDto task = taskService.getTask(projectId, taskId);
        model.addAttribute("task", task);

        return "project";
    }
}
