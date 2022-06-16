package com.marino.demobank.services;

import com.marino.demobank.domain.DepositOrder;
import com.marino.demobank.domain.Transfer;
import com.marino.demobank.entities.DepositOrderEntity;
import com.marino.demobank.entities.TransferEntity;
import com.marino.demobank.interfaces.AccountOperationsInterface;
import com.marino.demobank.mapper.DepositOrderMapper;
import com.marino.demobank.mapper.DepositOrderMapperImpl;
import com.marino.demobank.mapper.TransferOrderMapper;
import com.marino.demobank.mapper.TransferOrderMapperImpl;
import com.marino.demobank.repositories.DepositOrderEntityRepository;
import com.marino.demobank.repositories.TransferEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountOperationsServiceAdapter implements AccountOperationsInterface {

    @Autowired
    private DepositOrderEntityRepository depositOrderEntityRepository;
    @Autowired
    private TransferEntityRepository transferEntityRepository;

    private DepositOrderMapper depositOrderMapper = new DepositOrderMapperImpl();
    private TransferOrderMapper transferOrderMapper = new TransferOrderMapperImpl();

    @Override
    public DepositOrder deposit(DepositOrder depositOrder) {
        DepositOrderEntity newEntity = depositOrderMapper.domainToEntity(depositOrder);
        DepositOrderEntity result = depositOrderEntityRepository.save(newEntity);
        DepositOrder order = depositOrderMapper.entityToDomain(result);
        return order;
    }

    @Override
    public Transfer transfer(Transfer transferOrder) {
        TransferEntity newEntity = transferOrderMapper.domainToEntity(transferOrder);
        TransferEntity result = transferEntityRepository.save(newEntity);
        Transfer transfer = transferOrderMapper.entityToDomain(result);
        return transfer;
    }
}
