package ru.otus.microservice.architecture.contract.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.microservice.architecture.contract.model.dto.ContractDto;
import ru.otus.microservice.architecture.contract.model.entity.ContractEntity;

@Component
public class ContractDtoToContractEntityConverter implements Converter<ContractDto, ContractEntity> {
    @Override
    public ContractEntity convert(ContractDto contractDto) {
        ContractEntity contractEntity = new ContractEntity();
        contractEntity.setId(null);
        contractEntity.setCourseId(contractDto.getCourseId());
        contractEntity.setPromoId(contractDto.getPromoId());
        contractEntity.setTemplate(contractDto.getTemplate());
        contractEntity.setStatus(contractDto.getStatus());
        return contractEntity;
    }
}