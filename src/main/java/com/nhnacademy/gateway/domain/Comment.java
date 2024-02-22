package com.nhnacademy.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class Comment {
    private int commentID;
    private int taskId;
    private long memberId;
    private String contents;
}
