package com.marino.demobank.repositories;

import com.marino.demobank.entities.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferEntityRepository extends JpaRepository<TransferEntity, String> {
}