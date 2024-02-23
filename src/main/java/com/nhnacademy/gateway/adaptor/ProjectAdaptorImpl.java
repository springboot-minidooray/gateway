package com.nhnacademy.gateway.adaptor;

import com.nhnacademy.gateway.config.ApiProperties;
import com.nhnacademy.gateway.domain.Project;
import com.nhnacademy.gateway.domain.dto.AccountDto;
import com.nhnacademy.gateway.domain.dto.ProjectDto;
import com.nhnacademy.gateway.domain.dto.ProjectListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectAdaptorImpl implements ProjectAdaptor{
    private final RestTemplate restTemplate;
    private final ApiProperties apiProperties;

    @Override
    public List<ProjectListDto> getProjectList(String id) {
        return null;
    }

    @Override
    public ProjectDto getProject(Long projectId) {
        return null;
    }

    @Override
    public void createProject(Project project) {

    }

    @Override
    public void updateProject(Project project) {

    }

    @Override
    public void deleteProject(String id) {

    }
}
