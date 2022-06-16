package com.marino.demobank.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode
public class AccountCreationDTO {
    private String accountNumberIban;
    private String accountNumberCCC;
    private List<String> holdersIds;
}
