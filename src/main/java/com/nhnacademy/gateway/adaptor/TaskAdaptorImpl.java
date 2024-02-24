package com.nhnacademy.gateway.adaptor;

import com.nhnacademy.gateway.config.ApiProperties;
import com.nhnacademy.gateway.domain.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskAdaptorImpl implements TaskAdaptor{
    private final RestTemplate restTemplate;
    private final ApiProperties apiProperties;

    @Override
    public TaskDto getTask(Long projectId, int taskId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        String url = apiProperties.getTaskApi() + "projects/{projectId}/tasks/{taskId}";
        ResponseEntity<TaskDto> exchange = restTemplate.exchange(url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<TaskDto>() {
                },projectId, taskId);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }
}
