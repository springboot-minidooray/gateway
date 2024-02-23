package com.nhnacademy.gateway.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MilestoneDto {
    private String milestoneName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
