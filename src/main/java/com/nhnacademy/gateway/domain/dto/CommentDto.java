package com.nhnacademy.gateway.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentDto {
    private String writerId;
    private String contents;
}
