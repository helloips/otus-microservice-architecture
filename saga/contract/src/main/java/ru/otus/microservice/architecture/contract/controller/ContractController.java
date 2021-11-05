package ru.otus.microservice.architecture.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.otus.microservice.architecture.contract.model.dto.ContractDto;
import ru.otus.microservice.architecture.contract.service.ContractService;

@RestController
public class ContractController {
    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping("digital/v1/contract")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ContractDto create(@RequestBody ContractDto contractDto) {
        return contractService.create(contractDto);
    }

    @GetMapping("digital/v1/contract/{id}")
    public ContractDto read(@PathVariable(name = "id") String id) {
        return contractService.read(id);
    }

    @PutMapping("digital/v1/contract/{id}")
    public ContractDto update(@PathVariable(name = "id") String id, @RequestBody ContractDto contractDto) {
        return contractService.update(id, contractDto);
    }

    @DeleteMapping("digital/v1/contract/{id}")
    public ContractDto delete(@PathVariable(name = "id") String id) {
        return contractService.delete(id);
    }
}