package com.nhnacademy.gateway.domain.request;

import lombok.Value;

@Value
public class ProjectRegisterRequest {
    String projectName;
    String projectManagerId;
}
