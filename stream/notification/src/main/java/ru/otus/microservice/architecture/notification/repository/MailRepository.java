package ru.otus.microservice.architecture.notification.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.microservice.architecture.notification.model.entity.MailEntity;

import java.util.List;

@Repository
public interface MailRepository extends CrudRepository<MailEntity, String> {
    List<MailEntity> findByAccountId(String accountId);
}