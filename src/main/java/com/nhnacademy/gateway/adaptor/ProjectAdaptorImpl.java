package com.nhnacademy.gateway.adaptor;

import com.nhnacademy.gateway.config.ApiProperties;
import com.nhnacademy.gateway.domain.Account;
import com.nhnacademy.gateway.domain.Project;
import com.nhnacademy.gateway.domain.dto.AccountDto;
import com.nhnacademy.gateway.domain.dto.ProjectDto;
import com.nhnacademy.gateway.domain.dto.ProjectListDto;
import com.nhnacademy.gateway.domain.request.ProjectRegisterRequest;
import com.nhnacademy.gateway.exception.UserAlreadyExistException;
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
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        String url = apiProperties.getTaskApi() + "/projects/user/{id}";
        ResponseEntity<List<ProjectListDto>> exchange = restTemplate.exchange(url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<ProjectListDto>>() {
                }, id);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public ProjectDto getProject(Long projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        String url = apiProperties.getTaskApi() + "/projects/{projectId}";
        ResponseEntity<ProjectDto> exchange = restTemplate.exchange(url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<ProjectDto>() {
                }, projectId);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public void createProject(ProjectRegisterRequest projectRegisterRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectRegisterRequest> requestEntity = new HttpEntity<>(projectRegisterRequest, httpHeaders);
        ResponseEntity<ProjectDto> exchange = restTemplate.exchange(apiProperties.getTaskApi() + "/projects",
                HttpMethod.POST,
                requestEntity,
                ProjectDto.class);
        if (exchange.getStatusCode() != HttpStatus.CREATED) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateProject(Project project) {

    }

    @Override
    public void deleteProject(Long projectId) {
        String url = apiProperties.getTaskApi() + "/projects/{projectId}";
        ResponseEntity<Void> exchange = restTemplate.exchange(url,
                HttpMethod.DELETE,
                null,
                Void.class, projectId);
    }

}
