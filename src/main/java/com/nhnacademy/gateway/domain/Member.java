package com.nhnacademy.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class Member {
    private long memberId;
    private long projectId;
}
