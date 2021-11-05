package ru.otus.microservice.architecture.contract.service;

import ru.otus.microservice.architecture.contract.model.dto.ContractDto;

public interface ContractService {
    ContractDto create(ContractDto contractDto);
    ContractDto read(String id);
    ContractDto update(String id, ContractDto contractDto);
    ContractDto delete(String id);
}