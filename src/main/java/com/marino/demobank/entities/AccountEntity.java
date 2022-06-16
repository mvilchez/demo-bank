package com.marino.demobank.entities;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class AccountEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "iban", nullable = false)
    private String accountNumberIban;
    @Column(name = "ccc")
    private String accountNumberCCC;
    @Column(name = "holder")
    private String holder;

    public AccountEntity() {
    }

    public AccountEntity(String accountNumberIban, String accountNumberCCC, String holder) {
        this.accountNumberIban = accountNumberIban;
        this.accountNumberCCC = accountNumberCCC;
        this.holder = holder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumberIban() {
        return accountNumberIban;
    }

    public void setAccountNumberIban(String accountNumberIban) {
        this.accountNumberIban = accountNumberIban;
    }

    public String getAccountNumberCCC() {
        return accountNumberCCC;
    }

    public void setAccountNumberCCC(String accountNumberCCC) {
        this.accountNumberCCC = accountNumberCCC;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }
}
