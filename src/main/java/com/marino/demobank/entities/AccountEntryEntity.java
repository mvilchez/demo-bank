package com.marino.demobank.entities;

import javax.persistence.*;

@Entity
@Table(name = "accountEntries")
public class AccountEntryEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "accountId", nullable = false)
    private String accountId;
    @Column(name = "amount", nullable = false)
    private Double amount;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "date", nullable = false)
    private String date;

    public AccountEntryEntity() {
    }

    public AccountEntryEntity(String accountId, Double amount, String description, String date) {
        this.accountId = accountId;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
