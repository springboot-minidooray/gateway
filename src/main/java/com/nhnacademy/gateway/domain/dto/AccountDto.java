package com.nhnacademy.gateway.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String id;
    private String password;
    private String email;
}
