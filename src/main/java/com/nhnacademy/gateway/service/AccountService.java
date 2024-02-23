package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.adaptor.AccountAdaptor;
import com.nhnacademy.gateway.domain.Account;
import com.nhnacademy.gateway.domain.dto.AccountDto;
import com.nhnacademy.gateway.exception.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountAdaptor accountAdaptor;

    public boolean login(String userId, String password) {
        AccountDto account = accountAdaptor.getAccount(userId);
        if (account == null || account.getPassword() == null) {
            return false;
        }
        return account.getPassword().equals(password);
    }

    public boolean signup(String userId, String password, String email) {
        try {
            accountAdaptor.createAccount(new AccountDto(userId, password, email));
            return true;
        } catch (UserAlreadyExistException e) {
            return false;
        }
    }

    public void signout(String userId) {
        accountAdaptor.deleteAccount(userId);
    }
}
