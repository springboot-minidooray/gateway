package com.nhnacademy.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class Tag {
    private long id;
    private long projectId;
    private String tagName;
}
