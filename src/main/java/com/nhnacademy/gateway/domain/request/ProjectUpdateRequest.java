package com.nhnacademy.gateway.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProjectUpdateRequest {
    String projectName;
    String projectStatus;
}
