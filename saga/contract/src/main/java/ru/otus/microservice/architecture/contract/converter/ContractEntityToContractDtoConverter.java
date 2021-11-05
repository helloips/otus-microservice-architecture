package ru.otus.microservice.architecture.contract.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.microservice.architecture.contract.model.dto.ContractDto;
import ru.otus.microservice.architecture.contract.model.entity.ContractEntity;

@Component
public class ContractEntityToContractDtoConverter implements Converter<ContractEntity, ContractDto> {
    @Override
    public ContractDto convert(ContractEntity contractEntity) {
        ContractDto contractDto = new ContractDto();
        contractDto.setId(contractEntity.getId());
        contractDto.setCourseId(contractEntity.getCourseId());
        contractDto.setPromoId(contractEntity.getPromoId());
        contractDto.setTemplate(contractEntity.getTemplate());
        contractDto.setStatus(contractEntity.getStatus());
        return contractDto;
    }
}