package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.domain.dto.ProjectListDto;
import com.nhnacademy.gateway.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public String getProjectList(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            String userId = String.valueOf(session.getAttribute("userId"));
            List<ProjectListDto> projectList =  projectService.getProjectList(userId);

            model.addAttribute("projectList", projectList);
            return "projectList";
        }
        return "redirect:/";
    }


    @GetMapping("/{projectId}")
    public String getProject(@PathVariable Long projectId) {

        return "project";
    }
}
