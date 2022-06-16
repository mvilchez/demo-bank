package com.marino.demobank.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marino.demobank.domain.Account;
import com.marino.demobank.domain.AccountEntry;
import com.marino.demobank.domain.Balance;
import com.marino.demobank.interfaces.AccountInterface;
import com.marino.demobank.mapper.AccountEntriesMapper;
import com.marino.demobank.mapper.AccountMapper;
import com.marino.demobank.mapper.BalanceMapper;
import com.marino.demobank.model.AccountCreation;
import com.marino.demobank.model.AccountModel;
import com.marino.demobank.model.DepositOrder;
import com.marino.demobank.model.OverallAccountPosition;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class AccountApiController implements AccountApi {

    private final AccountInterface accountInterface;

    private static final Logger log = LoggerFactory.getLogger(AccountApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public AccountApiController(ObjectMapper objectMapper, HttpServletRequest request,
                                AccountInterface accountInterface) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.accountInterface = accountInterface;
    }

    public ResponseEntity<Void> addAccount(@ApiParam(value = "Account object that needs to be added to the " +
            "bank", required = true) @Valid @RequestBody AccountCreation body) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Map<String, Integer>> depositIntoAccount(@ApiParam(value = "Deposit order that " +
            "contains import and description of a deposit that will be added to an account", required =
            true) @Valid @RequestBody DepositOrder body) {
        try {
            return new ResponseEntity<Map<String, Integer>>(objectMapper.readValue("{\"empty\": false}"
                    , Map.class), HttpStatus.NOT_IMPLEMENTED);
        } catch (IOException e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<AccountModel>> findByUser(@NotNull @ApiParam(value = "user id value that " +
            "need to be considered for filter", required = true) @Valid @RequestParam(value = "userId") String userId) {

        List<AccountModel> accountModels =
                AccountMapper.INSTANCE.mapToModel(accountInterface.getAccountByUserId(userId));
        return new ResponseEntity(accountModels, HttpStatus.OK);
    }

    public ResponseEntity<OverallAccountPosition> viewAccountDetails(@NotNull @ApiParam(value = "account id" +
            " value that need to be considered for filter", required = true) @Valid @RequestParam(value =
            "accountId") String accountId) {
        Account accountModel = accountInterface.getAccount(accountId);
        Balance balance = accountInterface.getBalance(accountModel.getId());
        List<AccountEntry> entries = accountInterface.getAccountEntries(accountModel.getId());
        OverallAccountPosition overallAccountPosition = new OverallAccountPosition();
        overallAccountPosition.accountId(accountId);
        overallAccountPosition.setBalance(BalanceMapper.INSTANCE.domainToModel(balance));
        overallAccountPosition.setMovements(AccountEntriesMapper.INSTANCE.domainToModel(entries));
        overallAccountPosition.setDate(balance.getDate());
        return new ResponseEntity<>(overallAccountPosition, HttpStatus.OK);
    }

}
