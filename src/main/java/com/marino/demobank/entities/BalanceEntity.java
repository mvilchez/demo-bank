package com.marino.demobank.entities;

import javax.persistence.*;

@Entity
@Table(name = "balances")
public class BalanceEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "accountId", nullable = false)
    private String accountId;
    @Column(name = "amount", nullable = false)
    private Double amount;
    @Column(name = "date", nullable = false)
    private String date;

    public BalanceEntity() {
    }

    public BalanceEntity(String accountId, Double amount, String date) {
        this.accountId = accountId;
        this.amount = amount;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
