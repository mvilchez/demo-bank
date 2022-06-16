package com.marino.demobank.mapper;

import com.marino.demobank.domain.Balance;
import com.marino.demobank.entities.BalanceEntity;
import com.marino.demobank.model.BalanceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Service
public interface BalanceMapper {
    BalanceMapper INSTANCE = Mappers.getMapper(BalanceMapper.class);

    @Mappings(
            @Mapping(source = "entity.amount", target = "balanceAmount")
    )
    Balance entityToDomain(BalanceEntity entity);

    @Mappings(
            @Mapping(source = "domain.balanceAmount", target = "amount")
    )
    BalanceEntity domainToEntity(Balance domain);

    BalanceModel domainToModel(Balance domain);
}
