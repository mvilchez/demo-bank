package com.marino.demobank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marino.demobank.api.AccountApiController;
import com.marino.demobank.domain.Account;
import com.marino.demobank.domain.AccountEntry;
import com.marino.demobank.domain.Balance;
import com.marino.demobank.domain.User;
import com.marino.demobank.interfaces.AccountInterface;
import com.marino.demobank.interfaces.AccountOperationsInterface;
import com.marino.demobank.interfaces.UserInterface;
import com.marino.demobank.mapper.AccountEntriesMapper;
import com.marino.demobank.mapper.BalanceMapper;
import com.marino.demobank.model.AccountEntryModel;
import com.marino.demobank.model.AccountModel;
import com.marino.demobank.model.BalanceModel;
import com.marino.demobank.model.OverallAccountPosition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountApiController.class)
class AccountModelApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountInterface accountInterface;

    @MockBean
    private AccountOperationsInterface accountOperationsInterface;

    @MockBean
    private UserInterface userInterface;

    @Test
    void shouldReturnListOfAccountsByUserId() throws Exception {
        User user = User.builder().
                id("id0001")
                .build();
        Account account1 = Account.builder()
                .id("acc00001")
                .accountNumberIban("3423432324324324")
                .accountNumberCCC("234234324324")
                .user(user)
                .build();
        Account account2 = Account.builder()
                .id("acc00002")
                .accountNumberIban("345345345345")
                .accountNumberCCC("45345345435")
                .user(user)
                .build();
        when(accountInterface.getAccountByUserId("id0001")).thenReturn(asList(account1, account2));

        MvcResult rt = this.mockMvc.perform(
                        get("/v1/account/findByUser")
                                .param("userId", "id0001"))
                .andExpect(status().isOk())
                .andReturn();
        String json = rt.getResponse().getContentAsString();
        List<AccountModel> accountList = new ObjectMapper().readValue(json, List.class);
        Assert.isTrue(accountList != null, "List is null");
        Assert.isTrue(accountList.size() == 2, "List size is not 2");
    }

    @Test
    void shouldReturnAccountByAccountId() throws Exception {
        User user = User.builder().
                id("id0001")
                .build();
        Account account1 = Account.builder()
                .id("acc00001")
                .accountNumberIban("3423432324324324")
                .accountNumberCCC("234234324324")
                .user(user)
                .build();

        Balance expectedBalance = Balance.builder()
                .accountId("account0000001")
                .balanceAmount(200.64)
                .date("2022-06-16T15:08:12")
                .build();

        AccountEntry expectedAccountEntry1 = AccountEntry.builder()
                .accountId("account0000001")
                .amount("20.64")
                .description("Payment HBOMax")
                .date("2022-06-16T15:08:12") // 2011-12-03T10:15:30
                .build();
        AccountEntry expectedAccountEntry2 = AccountEntry.builder()
                .accountId("account0000001")
                .amount("75.64")
                .description("Payment Booking")
                .date("2022-06-16T12:08:12")
                .build();

        BalanceModel balanceModel = BalanceMapper.INSTANCE.domainToModel(expectedBalance);
        AccountEntryModel accountEntryModel1 =
                AccountEntriesMapper.INSTANCE.domainToModel(expectedAccountEntry1);
        AccountEntryModel accountEntryModel2 =
                AccountEntriesMapper.INSTANCE.domainToModel(expectedAccountEntry2);

        OverallAccountPosition expectedOverallAccountPosition = new OverallAccountPosition();
        expectedOverallAccountPosition.setAccountId(account1.getId());
        expectedOverallAccountPosition.setMovements(Arrays.asList(accountEntryModel1, accountEntryModel2));
        expectedOverallAccountPosition.setBalance(balanceModel);
        expectedOverallAccountPosition.setDate(balanceModel.getDate());


        when(accountInterface.getAccount("acc00001")).thenReturn(account1);
        when(accountInterface.getAccountEntries("acc00001")).thenReturn(Arrays.asList(expectedAccountEntry1
                , expectedAccountEntry2));
        when(accountInterface.getBalance("acc00001")).thenReturn(expectedBalance);

        MvcResult rt = this.mockMvc.perform(
                        get("/v1/account/view")
                                .param("accountId", "acc00001"))
                //.andExpect(status().isOk())
                .andReturn();
        String json = rt.getResponse().getContentAsString();
        OverallAccountPosition overallAccountPosition = new ObjectMapper().readValue(json,
                OverallAccountPosition.class);
        Assert.isTrue(overallAccountPosition != null, "Overall position is null");
        Assert.isTrue(overallAccountPosition.getAccountId().equals(
                expectedOverallAccountPosition.getAccountId()), "Overall accountId is not the same");
        Assert.isTrue(overallAccountPosition.getBalance() != null,
                "Overall balance is null");
        Assert.isTrue(overallAccountPosition.getMovements() != null,
                "Overall movements is null");
    }
}
