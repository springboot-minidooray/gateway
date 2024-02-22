package com.nhnacademy.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class Account {
    private String id;
    private String email;
    private String password;
    private String accountStatus;
}
