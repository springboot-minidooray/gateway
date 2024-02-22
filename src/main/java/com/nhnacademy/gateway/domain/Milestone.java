package com.nhnacademy.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Milestone {
    private long milestoneId;
    private long projectId;
    private String milestoneName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean hasPeriod;
}
