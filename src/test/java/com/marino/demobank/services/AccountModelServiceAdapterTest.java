package com.marino.demobank.services;

import com.marino.demobank.domain.Account;
import com.marino.demobank.domain.AccountEntry;
import com.marino.demobank.domain.Balance;
import com.marino.demobank.domain.User;
import com.marino.demobank.dto.AccountCreationDTO;
import com.marino.demobank.entities.AccountEntity;
import com.marino.demobank.entities.AccountEntryEntity;
import com.marino.demobank.entities.BalanceEntity;
import com.marino.demobank.mapper.AccountEntriesMapper;
import com.marino.demobank.mapper.AccountMapper;
import com.marino.demobank.mapper.BalanceMapper;
import com.marino.demobank.repositories.AccountEntityRepository;
import com.marino.demobank.repositories.AccountEntriesEntityRepository;
import com.marino.demobank.repositories.BalanceEntityRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.util.Assert.isTrue;

@RunWith(MockitoJUnitRunner.class)
public class AccountModelServiceAdapterTest {

    @InjectMocks
    AccountServiceAdapter accountServiceAdapter;
    @Mock
    AccountEntityRepository accountEntityRepository;
    @Mock
    AccountEntriesEntityRepository accountEntriesEntityRepository;
    @Mock
    BalanceEntityRepository balanceEntityRepository;

    @BeforeEach
    public void init() {
        // init mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateAnAccount() {
        AccountCreationDTO creationDTO = AccountCreationDTO.builder()
                .accountNumberCCC("01282023339636065216")
                .accountNumberIban("MG1478198455695538998783814")
                .holdersIds(Collections.singletonList("id00001"))
                .build();

        AccountEntity expectedAccountEntity = AccountMapper.INSTANCE.accountCreationDTOToAccountEntity(creationDTO);
        Account expectedAccount = AccountMapper.INSTANCE.accountEntityToAccount(expectedAccountEntity);

        when(accountEntityRepository.save(any(AccountEntity.class)))
                .thenReturn(expectedAccountEntity);

        Account newAccount = accountServiceAdapter.createAccount(creationDTO);

        isTrue(newAccount != null, "Expected account is Null");
        isTrue(newAccount.getAccountNumberIban().equals(expectedAccount.getAccountNumberIban())
                , "Expected account IBAN is not the same");
        isTrue(newAccount.getAccountNumberCCC().equals(expectedAccount.getAccountNumberCCC())
                , "Expected account IBAN is not the same");
        /*
        TODO
        isTrue(newAccount.getHolders() != null
                , "Expected account holders are empty or null");
        isTrue(newAccount.getHolders().equals(expectedAccount.getHolders())
                , "Expected account Holders are not the same");

         */
    }

    @Test
    public void shouldNotReturnAnAccountWithUnknownAccountId() {
        when(accountEntityRepository.findAccountById(any(String.class)))
                .thenReturn(null);

        Account retrievedAccount = accountServiceAdapter.getAccount("unknownAccountId");

        isTrue(retrievedAccount == null, "Expected account is not null");
    }

    @Test
    public void shouldReturnAnAccountById() {
        User user = User.builder()
                .id("id0001")
                .firstName("Marino")
                .lastName("Vilchez")
                .email("myemail@fake.com")
                .phone("555-123456")
                .userStatus("ACTIVE")
                .build();
        Account expectedAccount = Account.builder()
                .id("account0000001")
                .accountNumberIban("MG1478198455695538998783814")
                .accountNumberCCC("01282023339636065216")
                .user(user)
                .build();

        Balance expectedBalance = Balance.builder()
                .accountId("account0000001")
                .balanceAmount(200.64)
                .date("2022-06-16 15:08:12")
                .build();

        AccountEntry expectedAccountEntry1 = AccountEntry.builder()
                .accountId("account0000001")
                .date("2022-06-16 15:08:12")
                .amount("20.64")
                .description("Payment HBOMax")
                .build();
        AccountEntry expectedAccountEntry2 = AccountEntry.builder()
                .accountId("account0000001")
                .date("2022-06-16 12:08:12")
                .amount("175.64")
                .description("Payment Booking.com")
                .build();

        List<AccountEntry> expectedAccountEntries = Arrays.asList(expectedAccountEntry1, expectedAccountEntry2);

        AccountEntity expectedAccountEntity = AccountMapper.INSTANCE.accountToAccountEntity(expectedAccount);
        BalanceEntity expectedBalanceEntity = BalanceMapper.INSTANCE.domainToEntity(expectedBalance);

        List<AccountEntryEntity> expectedAccountEntriesEntities = AccountEntriesMapper.INSTANCE.mapToEntity(expectedAccountEntries);

        when(accountEntityRepository.findAccountById("account0000001"))
                .thenReturn(expectedAccountEntity);
       /* when(balanceEntityRepository.findByAccountId("account0000001"))
                .thenReturn(expectedBalanceEntity);
        when(accountEntriesEntityRepository.findByAccountId("account0000001"))
                .thenReturn(expectedAccountEntriesEntities);*/

        Account retrievedAccount = accountServiceAdapter.getAccount("account0000001");

        isTrue(retrievedAccount != null, "Expected account is Null");
        isTrue(retrievedAccount.getAccountNumberIban().equals(expectedAccount.getAccountNumberIban())
                , "Expected account IBAN is not the same");
        isTrue(retrievedAccount.getAccountNumberCCC().equals(expectedAccount.getAccountNumberCCC())
                , "Expected account IBAN is not the same");
         /*
        TODO
        isTrue(newAccount.getHolders() != null
                , "Expected account holders are empty or null");
        isTrue(newAccount.getHolders().equals(expectedAccount.getHolders())
                , "Expected account Holders are not the same");

         */
    }

    @Test
    public void shouldReturnAListOfAccountsByUserId() {
        User me = User.builder()
                .id("id0001")
                .firstName("Marino")
                .lastName("Vilchez")
                .email("myemail@fake.com")
                .phone("555-123456")
                .userStatus("ACTIVE")
                .build();
        User anotheruser = User.builder()
                .id("id0002")
                .firstName("Rocío")
                .lastName("Jurado")
                .email("mywifeemail@fake.com")
                .phone("555-123432")
                .userStatus("ACTIVE")
                .build();
        Account expectedMainAccount = Account.builder()
                .id("account0000001")
                .accountNumberIban("MG1478198455695538998783344")
                .accountNumberCCC("01282023339636065221")
                .user(me)
                .build();
        Account expectedFamiliarAccount = Account.builder()
                .id("account0000002")
                .accountNumberIban("MG1478198455695538998783814")
                .accountNumberCCC("01282023339636065216")
                .user(anotheruser)
                .build();

        AccountEntity expectedAccountEntity1 = AccountMapper.INSTANCE.accountToAccountEntity(expectedMainAccount);
        AccountEntity expectedAccountEntity2 = AccountMapper.INSTANCE.accountToAccountEntity(expectedFamiliarAccount);

        when(accountEntityRepository.findAccountsByHolder("id0001"))
                .thenReturn(Arrays.asList(expectedAccountEntity1, expectedAccountEntity2));

        List<Account> retrievedAccounts = accountServiceAdapter.getAccountByUserId(me.getId());

        isTrue(retrievedAccounts != null, "Expected account list is Null");
        isTrue(!retrievedAccounts.isEmpty(), "Account list is empty");
        isTrue(2 == retrievedAccounts.size(), "Account list size is not 2");
    }

    @Test
    public void shouldReturnAListOfAccountEntries() {
        AccountEntryEntity firstEntry = new AccountEntryEntity("account0000002",
                10.30, "Netflix payment", "15-06-2022 3:17:68");
        AccountEntryEntity secondEntry = new AccountEntryEntity("account0000002",
                150.30, "Booking rentals", "12-06-2022 13:18:68");

        AccountEntry accountEntry1 = AccountEntriesMapper.INSTANCE.accountEntryEntityToAccount(firstEntry);
        AccountEntry accountEntry2 = AccountEntriesMapper.INSTANCE.accountEntryEntityToAccount(secondEntry);
        List<AccountEntry> expectedEntries = new ArrayList<>();
        expectedEntries.add(accountEntry1);
        expectedEntries.add(accountEntry2);

        when(accountEntriesEntityRepository.findByAccountId("account0000002"))
                .thenReturn(Arrays.asList(firstEntry, secondEntry));

        List<AccountEntry> retrievedAccountEntries = accountServiceAdapter.getAccountEntries("account0000002");

        isTrue(retrievedAccountEntries != null, "Expected account entries list is Null");
        isTrue(!retrievedAccountEntries.isEmpty(), "Account entries list is empty");
    }

    @Test
    public void shouldReturnBalance() {

        BalanceEntity balanceEntity = new BalanceEntity("account0000002", 3000.02, "16-06-2022 10:09:47");
        Balance expectedBalance = BalanceMapper.INSTANCE.entityToDomain(balanceEntity);

        when(balanceEntityRepository.findByAccountId("account0000002"))
                .thenReturn(balanceEntity);

        Balance balance = accountServiceAdapter.getBalance("account0000002");

        isTrue(balance != null, "Balance is null");
        isTrue(balance.getBalanceAmount().equals(expectedBalance.getBalanceAmount()), "Balance amount is not the same");
        isTrue(balance.getDate().equals(expectedBalance.getDate()), "Balance date is not the same");
        isTrue(balance.getAccountId().equals(expectedBalance.getAccountId()), "Balance accountId is not the same");

    }
}
