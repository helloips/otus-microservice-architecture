package ru.otus.microservice.architecture.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.microservice.architecture.notification.model.domain.Mail;
import ru.otus.microservice.architecture.notification.service.MailService;

import java.util.List;

@RestController
public class MailController {
    private final MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping(path = "/mail")
    public List<Mail> findByAccountId(@RequestParam(name = "accountId") String accountId) {
        return mailService.findByAccountId(accountId);
    }
}