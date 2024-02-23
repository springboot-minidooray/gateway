package com.nhnacademy.gateway.adaptor;

import com.nhnacademy.gateway.domain.Account;
import com.nhnacademy.gateway.domain.dto.AccountDto;

public interface AccountAdaptor {
    AccountDto getAccount(String id);
    void createAccount(AccountDto account);
    void updateAccount(AccountDto account);
    void deleteAccount(String id);
}
