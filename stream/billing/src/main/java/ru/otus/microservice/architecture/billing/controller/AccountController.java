package ru.otus.microservice.architecture.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.otus.microservice.architecture.billing.model.domain.Account;
import ru.otus.microservice.architecture.billing.service.AccountService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(path = "/account")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Account account, HttpServletResponse httpServletResponse) {
        String accountId = accountService.create(account);
        httpServletResponse.setHeader("X-Account-Id", accountId);
    }

    @GetMapping(path = "/account/{id}")
    public Account find(@PathVariable(name = "id") String id) {
        return accountService.findById(id);
    }

    @PostMapping(path = "/account/{id}/money")
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@PathVariable(name = "id") String id, @RequestParam(name = "coins") Double coins) {
        accountService.update(id, coins);
    }
}