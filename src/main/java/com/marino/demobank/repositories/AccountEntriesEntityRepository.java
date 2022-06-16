package com.marino.demobank.repositories;

import com.marino.demobank.entities.AccountEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountEntriesEntityRepository extends JpaRepository<AccountEntryEntity, String> {
    List<AccountEntryEntity> findByAccountId(String accountId);
}
