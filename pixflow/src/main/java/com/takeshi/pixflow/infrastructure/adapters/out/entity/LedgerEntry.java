package com.takeshi.pixflow.infrastructure.adapters.out.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ledger_entries")
public class LedgerEntry {

    @Id
    private String id;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "entry_type", nullable = false)
    private String entryType;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public LedgerEntry() {
    }

    public LedgerEntry(String id, String accountId, String transactionId, String entryType, BigDecimal amount) {
        this.id = id;
        this.accountId = accountId;
        this.transactionId = transactionId;
        this.entryType = entryType;
        this.amount = amount;
        this.createdAt = createdAt;
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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
