package com.nhnacademy.gateway.adaptor;

import com.nhnacademy.gateway.domain.Account;

public interface AccountAdaptor {
    Account getAccount(Long id);
    void createAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Long id);
}
