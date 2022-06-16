package com.marino.demobank.interfaces;

import com.marino.demobank.domain.Balance;
import com.marino.demobank.dto.AccountCreationDTO;
import com.marino.demobank.domain.Account;
import com.marino.demobank.domain.AccountEntry;

import java.util.List;

public interface AccountInterface {
    public Account createAccount(AccountCreationDTO accountCreationDTO);

    public Account getAccount(String accountId);

    public List<Account> getAccountByUserId(String userId);

    public List<AccountEntry> getAccountEntries(String accountId);

    public Balance getBalance(String accountId);
}
