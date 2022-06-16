package com.marino.demobank.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class DepositOrder {
    private Double amount;
    private String description;
    private String destinationAccountId;
    private String date;
}
