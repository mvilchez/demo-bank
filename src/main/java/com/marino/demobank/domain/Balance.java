package com.marino.demobank.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Balance {
    private String accountId;
    private Double balanceAmount;
    private String date;
}
