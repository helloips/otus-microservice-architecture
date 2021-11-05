package ru.otus.microservice.architecture.contract.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.microservice.architecture.contract.model.entity.ContractEntity;

@Repository
public interface ContractRepository extends CrudRepository<ContractEntity, String> {
}