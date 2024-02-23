package com.nhnacademy.gateway.adaptor;

import com.nhnacademy.gateway.config.ApiProperties;
import com.nhnacademy.gateway.domain.Account;
import com.nhnacademy.gateway.domain.dto.AccountDto;
import com.nhnacademy.gateway.exception.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountAdaptorImpl implements AccountAdaptor{
    private final RestTemplate restTemplate;
    private final ApiProperties apiProperties;

    @Override
    public AccountDto getAccount(String id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        String url = apiProperties.getAccountApi() + "/accounts/" + id;
        ResponseEntity<AccountDto> exchange = restTemplate.exchange(url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<AccountDto>() {
                });
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public void createAccount(AccountDto account) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<AccountDto> requestEntity = new HttpEntity<>(account, httpHeaders);
        String url = apiProperties.getAccountApi() + "/accounts";
        ResponseEntity<Account> exchange = restTemplate.exchange(url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<Account>() {
                });
        if (exchange.getBody() == null || exchange.getBody().getId() == null) {
            throw new UserAlreadyExistException("user Already Exists");
        }
    }

    @Override
    public void updateAccount(AccountDto account) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(account.getPassword(), httpHeaders);
        String url = apiProperties.getAccountApi() + "/accounts/{id}";
        ResponseEntity<Void> exchange = restTemplate.exchange(url,
                HttpMethod.PUT,
                requestEntity,
                void.class, account.getId());
    }

    @Override
    public void deleteAccount(String id) {
        String url = apiProperties.getAccountApi() + "/accounts/{id}";
        ResponseEntity<Void> exchange = restTemplate.exchange(url,
                HttpMethod.DELETE,
                null,
                Void.class, id);
    }
}
