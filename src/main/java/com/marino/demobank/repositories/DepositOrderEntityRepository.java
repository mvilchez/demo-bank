package com.marino.demobank.repositories;

import com.marino.demobank.entities.DepositOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositOrderEntityRepository extends JpaRepository<DepositOrderEntity, String> {
}