package com.marino.demobank.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Account {
    private String id;
    private String accountNumberIban;
    private String accountNumberCCC;
    private User user;
}
