package ru.otus.microservice.architecture.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.microservice.architecture.billing.model.entity.AccountEntity;
import ru.otus.microservice.architecture.billing.model.domain.Account;
import ru.otus.microservice.architecture.billing.repository.AccountRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class DbAccountService implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public DbAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public String create(Account account) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setFullName(account.getFullName());
        accountEntity.setMoney(account.getMoney());
        accountEntity.setEmail(account.getEmail());
        accountRepository.save(accountEntity);
        return accountEntity.getId();
    }

    @Override
    @Transactional
    public Account findById(String id) {
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Account account = new Account();
        account.setFullName(accountEntity.getFullName());
        account.setMoney(accountEntity.getMoney());
        account.setEmail(accountEntity.getEmail());
        return account;
    }

    @Override
    @Transactional
    public void update(String id, Double money) {
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        accountEntity.setMoney(accountEntity.getMoney() + money);
    }
}