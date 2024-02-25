package com.nhnacademy.gateway.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProjectRegisterRequest {
    String projectName;
    String projectManagerId;
}
