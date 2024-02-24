package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.gateway.domain.dto.ProjectDto;
import com.nhnacademy.gateway.domain.dto.ProjectListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectAdaptor projectAdaptor;

    public List<ProjectListDto> getProjectList(String userId) {
       return projectAdaptor.getProjectList(userId);
    }

    public ProjectDto getProject(Long projectId){
        return projectAdaptor.getProject(projectId);
    }
}
