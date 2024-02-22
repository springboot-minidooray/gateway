package com.nhnacademy.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class Project {
    private long projectId;
    private long adminId;
    private String projectName;
    private String projectStatus;
}
