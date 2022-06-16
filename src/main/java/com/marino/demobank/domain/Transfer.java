package com.marino.demobank.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Transfer {
    private Double amount;
    private String destinationAccountId;
    private String originAccountId;
    private String date;
}
