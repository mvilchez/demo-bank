package com.marino.demobank.mapper;

import com.marino.demobank.domain.AccountEntry;
import com.marino.demobank.entities.AccountEntryEntity;
import com.marino.demobank.model.AccountEntryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Service
public interface AccountEntriesMapper {
    AccountEntriesMapper INSTANCE = Mappers.getMapper(AccountEntriesMapper.class);

    AccountEntry accountEntryEntityToAccount(AccountEntryEntity entity);

    List<AccountEntry> mapToDomain(List<AccountEntryEntity> accountEntries);

    AccountEntryEntity accountEntryToAccountEntryEntity(AccountEntry domain);

    List<AccountEntryEntity> mapToEntity(List<AccountEntry> accountEntries);

    List<AccountEntryModel> domainToModel(List<AccountEntry> accountEntries);

    AccountEntryModel domainToModel(AccountEntry accountEntry);
}
