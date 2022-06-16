package com.marino.demobank.mapper;

import com.marino.demobank.domain.Transfer;
import com.marino.demobank.entities.TransferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Service
public interface TransferOrderMapper {

    TransferOrderMapper INSTANCE = Mappers.getMapper(TransferOrderMapper.class);
    TransferEntity domainToEntity (Transfer domain);

    Transfer entityToDomain(TransferEntity entity);
}
