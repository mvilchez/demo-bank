package com.marino.demobank.services;

import com.marino.demobank.domain.DepositOrder;
import com.marino.demobank.domain.Transfer;
import com.marino.demobank.entities.AccountEntity;
import com.marino.demobank.entities.DepositOrderEntity;
import com.marino.demobank.entities.TransferEntity;
import com.marino.demobank.mapper.DepositOrderMapper;
import com.marino.demobank.mapper.TransferOrderMapper;
import com.marino.demobank.repositories.DepositOrderEntityRepository;
import com.marino.demobank.repositories.TransferEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AccountModelOperationsServiceAdapterTest {
    @InjectMocks
    private AccountOperationsServiceAdapter accountOperationsServiceAdapter = new AccountOperationsServiceAdapter();
    @Mock
    private DepositOrderEntityRepository depositOrderEntityRepository;
    @Mock
    private TransferEntityRepository transferEntityRepository;

    @BeforeEach
    public void init() {
        // init mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateADepositOrder() {
        DepositOrderEntity entity = new DepositOrderEntity("acc0000001", 20.02,
                "Invoice #202", "2022-06-15 10:03:03");
        DepositOrder depositOrder = DepositOrderMapper.INSTANCE.entityToDomain(entity);

        when(depositOrderEntityRepository.save(any(DepositOrderEntity.class)))
                .thenReturn(entity);

        DepositOrder actualDepositOrder = accountOperationsServiceAdapter.deposit(depositOrder);
        Assert.isTrue(depositOrder != null, "Expected order is null");
        Assert.isTrue(depositOrder.getDescription().equals(actualDepositOrder.getDescription()),
                "Expected order description is not the same");
        Assert.isTrue(depositOrder.getDate().equals(actualDepositOrder.getDate()),
                "Expected order date is not the same");
        Assert.isTrue(depositOrder.getAmount().equals(actualDepositOrder.getAmount()),
                "Expected order amount is not the same");
        Assert.isTrue(depositOrder.getDestinationAccountId().equals(actualDepositOrder.getDestinationAccountId()),
                "Expected order destination is not the same");
    }

    @Test
    void shouldCreateATransferOrder() {
        TransferEntity entity = new TransferEntity("acc0000002", "acc0000001",
                120.00, "Paga extra", "2022-06-15 10:03:03");
        Transfer expectedTransferOrder = TransferOrderMapper.INSTANCE.entityToDomain(entity);

        when(transferEntityRepository.save(any(TransferEntity.class)))
                .thenReturn(entity);

        Transfer actualDepositOrder = accountOperationsServiceAdapter.transfer(expectedTransferOrder);
        Assert.isTrue(actualDepositOrder != null, "Expected transfer order is null");
        Assert.isTrue(actualDepositOrder.getOriginAccountId().equals(expectedTransferOrder.getOriginAccountId())
                , "Expected transfer order origin account is not the same");
        Assert.isTrue(actualDepositOrder.getDestinationAccountId().equals(expectedTransferOrder.getDestinationAccountId())
                , "Expected transfer order destination account is not the same");
        Assert.isTrue(actualDepositOrder.getAmount().equals(expectedTransferOrder.getAmount())
                , "Expected transfer order amount account is not the same");
        Assert.isTrue(actualDepositOrder.getDate().equals(expectedTransferOrder.getDate())
                , "Expected transfer order origin account is not the same");
    }
}
