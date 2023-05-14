package com.example.seguimiento14.Model;

import java.time.LocalDate;

public class Ingreso extends Movements{
    private String description;
    private String type;
    private double amount;
    private LocalDate date;

    public Ingreso(String description, String type, double amount, LocalDate date) {
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date =date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
