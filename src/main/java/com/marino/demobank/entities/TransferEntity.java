package com.marino.demobank.entities;

import javax.persistence.*;

@Entity
@Table(name = "transferOrders")
public class TransferEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "originAccountId", nullable = false)
    private String originAccountId;
    @Column(name = "destinationAccountId", nullable = false)
    private String destinationAccountId;
    @Column(name = "amount", nullable = false)
    private Double amount;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "date", nullable = false)
    private String date;

    public TransferEntity(String originAccountId, String destinationAccountId, Double amount, String description, String date) {
        this.originAccountId = originAccountId;
        this.destinationAccountId = destinationAccountId;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public String getOriginAccountId() {
        return originAccountId;
    }

    public void setOriginAccountId(String originAccountId) {
        this.originAccountId = originAccountId;
    }

    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
