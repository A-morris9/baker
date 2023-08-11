package com.techelevator.model;

import java.math.BigDecimal;

public class Filling {
    private int filling_id;
    private String description;
    private BigDecimal cost;
    private int inventoryAmount;
    private boolean isAvailable;

    public Filling() {
    }

    public Filling(int filling_id, String description, BigDecimal cost, int inventoryAmount, boolean isAvailable) {
        this.filling_id = filling_id;
        this.description = description;
        this.cost = cost;
        this.inventoryAmount = inventoryAmount;
        this.isAvailable = isAvailable;
    }

    public int getFilling_id() {
        return filling_id;
    }

    public void setFilling_id(int filling_id) {
        this.filling_id = filling_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(int inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
