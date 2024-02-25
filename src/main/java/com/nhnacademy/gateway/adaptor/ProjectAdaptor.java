package com.nhnacademy.gateway.adaptor;

import com.nhnacademy.gateway.domain.Project;
import com.nhnacademy.gateway.domain.dto.AccountDto;
import com.nhnacademy.gateway.domain.dto.ProjectDto;
import com.nhnacademy.gateway.domain.dto.ProjectListDto;
import com.nhnacademy.gateway.domain.request.ProjectRegisterRequest;

import java.util.List;

public interface ProjectAdaptor {
    List<ProjectListDto> getProjectList(String id);
    ProjectDto getProject(Long projectId);
    void createProject(ProjectRegisterRequest projectRegisterRequest);
    void updateProject(Project project);
    void deleteProject(Long projectId);

}
