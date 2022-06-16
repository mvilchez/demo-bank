package com.marino.demobank.mapper;

import com.marino.demobank.domain.DepositOrder;
import com.marino.demobank.entities.DepositOrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Service
public interface DepositOrderMapper {

    DepositOrderMapper INSTANCE = Mappers.getMapper(DepositOrderMapper.class);
    DepositOrderEntity domainToEntity (DepositOrder domain);

    DepositOrder entityToDomain(DepositOrderEntity entity);
}
