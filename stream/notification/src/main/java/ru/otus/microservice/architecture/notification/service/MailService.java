package ru.otus.microservice.architecture.notification.service;

import ru.otus.microservice.architecture.notification.model.domain.Mail;

import java.util.List;

public interface MailService {
    List<Mail> findByAccountId(String accountId);
}