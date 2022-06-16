package com.marino.demobank.mapper;

import com.marino.demobank.domain.Account;
import com.marino.demobank.domain.User;
import com.marino.demobank.dto.AccountCreationDTO;
import com.marino.demobank.entities.AccountEntity;
import com.marino.demobank.model.AccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Service
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account accountEntityToAccount(AccountEntity entity);

    Account accountModelToAccount(AccountModel model);

    List<Account> mapToAccountDomain(List<AccountModel> accounts);

    List<AccountModel> mapToModel(List<Account> accounts);

    List<Account> mapToDomain(List<AccountEntity> accounts);

    AccountEntity accountToAccountEntity(Account domain);

    AccountEntity accountCreationDTOToAccountEntity(AccountCreationDTO dto);

    List<AccountEntity> mapToEntity(List<Account> accounts);

    default List<User> mapToUser(List<String> users) {
        List<User> usersList = new ArrayList<>();
        users.stream().map(userId -> usersList.add(User.builder().id(userId).build()));
        return usersList;
    }

    default List<String> map(List<User> users) {
        List<String> userIds = new ArrayList<>();
        users.stream().map(user -> userIds.add(user.getId()));
        return userIds;
    }
}
