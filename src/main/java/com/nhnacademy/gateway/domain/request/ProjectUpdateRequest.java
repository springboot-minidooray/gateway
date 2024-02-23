package com.nhnacademy.gateway.domain.request;

import lombok.Value;

@Value
public class ProjectUpdateRequest {
    String projectName;
    String projectStatus;
}
