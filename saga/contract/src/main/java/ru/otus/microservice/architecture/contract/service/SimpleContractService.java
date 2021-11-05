package ru.otus.microservice.architecture.contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.otus.microservice.architecture.contract.model.dto.ContractDto;
import ru.otus.microservice.architecture.contract.model.entity.ContractEntity;
import ru.otus.microservice.architecture.contract.repository.ContractRepository;

@Service
public class SimpleContractService implements ContractService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ContractRepository contractRepository;
    private final ConversionService conversionService;
    private final String orchestratorUri;

    @Autowired
    public SimpleContractService(ContractRepository contractRepository, ConversionService conversionService, @Value("${orchestrator.uri}") String orchestratorUri) {
        this.contractRepository = contractRepository;
        this.conversionService = conversionService;
        this.orchestratorUri = orchestratorUri;
    }

    @Override
    @Transactional
    public ContractDto create(ContractDto contractDto) {
        ContractEntity courseEntity = conversionService.convert(contractDto, ContractEntity.class);
        contractRepository.save(courseEntity);
        restTemplate.postForEntity(orchestratorUri, null, Void.class, courseEntity.getId());
        return conversionService.convert(courseEntity, ContractDto.class);
    }

    @Override
    @Transactional
    public ContractDto read(String id) {
        ContractEntity contractEntity = contractRepository.findById(id).orElseThrow();
        return conversionService.convert(contractEntity, ContractDto.class);
    }

    @Override
    @Transactional
    public ContractDto update(String id, ContractDto contractDto) {
        ContractEntity contractEntity = contractRepository.findById(id).orElseThrow();
        contractEntity.setCourseId(contractDto.getCourseId());
        contractEntity.setTemplate(contractDto.getTemplate());
        contractEntity.setStatus(contractDto.getStatus());
        return conversionService.convert(contractEntity, ContractDto.class);
    }

    @Override
    @Transactional
    public ContractDto delete(String id) {
        ContractEntity contractEntity = contractRepository.findById(id).orElseThrow();
        ContractDto contractDto = conversionService.convert(contractEntity, ContractDto.class);
        contractRepository.deleteById(id);
        return contractDto;
    }
}