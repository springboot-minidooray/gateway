package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.adaptor.AccountAdaptor;
import com.nhnacademy.gateway.domain.Account;
import com.nhnacademy.gateway.domain.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountAdaptor accountAdaptor;

    public boolean login(String userId, String password) {
        AccountDto account = accountAdaptor.getAccount(userId);
        return account.getPassword().equals(password);
    }
}
