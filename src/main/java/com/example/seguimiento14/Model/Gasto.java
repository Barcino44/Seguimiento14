package com.example.seguimiento14.Model;

import java.time.LocalDate;
import java.util.Date;

public class Gasto extends Movements {
    private String description;
    private double amount;
    private String type;

    private LocalDate date;

    public Gasto(String description, String type, double amount, LocalDate date) {
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public long orderByDate(){
        return date.toEpochDay();
    }
}
