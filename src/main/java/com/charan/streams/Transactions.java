package com.charan.streams;

import java.time.LocalDate;

public class Transactions {
    private String id;
    private LocalDate date;
    private double amount;

    public Transactions(String id, LocalDate date, Double amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
