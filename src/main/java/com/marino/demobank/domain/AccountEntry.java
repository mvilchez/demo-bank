package com.marino.demobank.domain;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class AccountEntry {
    private String accountId;
    private String amount;
    private String description;
    private String date;
}
