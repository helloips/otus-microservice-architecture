package ru.otus.microservice.architecture.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.microservice.architecture.notification.model.domain.Mail;
import ru.otus.microservice.architecture.notification.model.entity.MailEntity;
import ru.otus.microservice.architecture.notification.repository.MailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DbMailService implements MailService{
    private final MailRepository mailRepository;

    @Autowired
    public DbMailService(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    @Override
    public List<Mail> findByAccountId(String accountId) {
        List<MailEntity> mailEntities = mailRepository.findByAccountId(accountId);
        List<Mail> mails = new ArrayList<>();
        for (MailEntity mailEntity : mailEntities) {
            Mail mail = new Mail();
            mail.setAccountId(mailEntity.getAccountId());
            mail.setOrderId(mailEntity.getOrderId());
            mail.setEmail(mailEntity.getEmail());
            mail.setText(mailEntity.getText());
            mails.add(mail);
        }
        return mails;
    }
}