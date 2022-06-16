package com.marino.demobank;

import com.marino.demobank.api.AccountApiController;
import com.marino.demobank.api.TransferApiController;
import com.marino.demobank.api.UserApi;
import com.marino.demobank.api.UserApiController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@DirtiesContext
class DemoBankApplicationTests {

    @Autowired
    private AccountApiController accountApiController;
    @Autowired
    private TransferApiController transferApiController;
    @Autowired
    private UserApiController userApiController;

    @Test
    void contextLoads() {
        assertThat(accountApiController).isNotNull();
        assertThat(transferApiController).isNotNull();
        assertThat(userApiController).isNotNull();
    }

}
