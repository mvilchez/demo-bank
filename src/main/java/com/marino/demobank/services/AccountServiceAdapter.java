package com.marino.demobank.services;

import com.marino.demobank.domain.Account;
import com.marino.demobank.domain.AccountEntry;
import com.marino.demobank.domain.Balance;
import com.marino.demobank.dto.AccountCreationDTO;
import com.marino.demobank.entities.AccountEntity;
import com.marino.demobank.entities.AccountEntryEntity;
import com.marino.demobank.entities.BalanceEntity;
import com.marino.demobank.interfaces.AccountInterface;
import com.marino.demobank.mapper.*;
import com.marino.demobank.repositories.AccountEntityRepository;
import com.marino.demobank.repositories.AccountEntriesEntityRepository;
import com.marino.demobank.repositories.BalanceEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceAdapter implements AccountInterface {
    @Autowired
    private AccountEntityRepository accountEntityRepository;
    @Autowired
    private AccountEntriesEntityRepository accountEntriesEntityRepository;

    @Autowired
    private BalanceEntityRepository balanceEntityRepository;

    // TODO
    private AccountMapper mapper = new AccountMapperImpl();
    private AccountEntriesMapper mapperEntries = new AccountEntriesMapperImpl();
    private BalanceMapper mapperBalance = new BalanceMapperImpl();

    @Override
    public Account createAccount(AccountCreationDTO accountCreationDTO) {
        AccountEntity accountEntity = mapper.accountCreationDTOToAccountEntity(accountCreationDTO);
        AccountEntity entity = accountEntityRepository.save(accountEntity);
        Account domainResult = mapper.accountEntityToAccount(entity);
        return domainResult;
    }

    @Override
    public Account getAccount(String accountId) {
        AccountEntity entity = accountEntityRepository.findAccountById(accountId);
        Account result = mapper.accountEntityToAccount(entity);
        return result;
    }

    @Override
    public List<Account> getAccountByUserId(String userId) {
        List<AccountEntity> accounts = accountEntityRepository.findAccountsByHolder(userId);
        List<Account> result = mapper.mapToDomain(accounts);
        return result;
    }

    @Override
    public List<AccountEntry> getAccountEntries(String accountId) {
        List<AccountEntryEntity> accountEntriesEntities = accountEntriesEntityRepository.findByAccountId(accountId);
        List<AccountEntry> accountEntries = mapperEntries.mapToDomain(accountEntriesEntities);
        return accountEntries;
    }

    @Override
    public Balance getBalance(String accountId) {
        BalanceEntity result = balanceEntityRepository.findByAccountId(accountId);
        Balance resultDomain = mapperBalance.entityToDomain(result);
        return resultDomain;
    }
}
