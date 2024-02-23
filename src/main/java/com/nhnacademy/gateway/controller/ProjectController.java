package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.domain.dto.ProjectListDto;
import com.nhnacademy.gateway.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/user/{userId}")
    public String getProjectList(@PathVariable String userId) {
        List<ProjectListDto> projectList =  projectService.getProjectList(userId);

        return "projectList";
    }


    @GetMapping("/{projectId}")
    public String getProject() {

        return "project";
    }
}
