package com.marino.demobank.repositories;

import com.marino.demobank.entities.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceEntityRepository extends JpaRepository<BalanceEntity, String> {
    BalanceEntity findByAccountId(String accountId);
}