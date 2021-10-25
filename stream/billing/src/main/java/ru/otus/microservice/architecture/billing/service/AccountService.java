package ru.otus.microservice.architecture.billing.service;

import ru.otus.microservice.architecture.billing.model.domain.Account;

public interface AccountService {
    String create(Account account);
    Account findById(String id);
    void update(String id, Double money);
}