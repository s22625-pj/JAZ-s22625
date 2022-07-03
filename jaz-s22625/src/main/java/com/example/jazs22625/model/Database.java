package com.example.jazs22625.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Database {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromDate;
    private String toDate;
    private Long currencyCount;
    private LocalDateTime createdAt;

    public Database(){}

    public Database(String fromDate, String toDate, Long currencyCount) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.currencyCount = currencyCount;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Long getCurrencyCount() {
        return currencyCount;
    }

    public void setCurrencyCount(Long currencyCount) {
        this.currencyCount = currencyCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
