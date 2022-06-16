package com.marino.demobank.repositories;

import com.marino.demobank.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountEntityRepository extends JpaRepository<AccountEntity, String> {
    List<AccountEntity> findAccountsByHolder(String userId);
    AccountEntity findAccountById(String accountId);
}