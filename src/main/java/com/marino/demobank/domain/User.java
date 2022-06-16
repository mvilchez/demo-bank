package com.marino.demobank.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String userStatus;
}
