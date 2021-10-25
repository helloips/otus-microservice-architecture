package ru.otus.microservice.architecture.billing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.microservice.architecture.billing.model.entity.AccountEntity;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, String> {
}