package com.techelevator.model;

import java.math.BigDecimal;

public class Frosting {
    private int frosting_id;
    private String description;
    private BigDecimal cost;
    private int inventoryAmount;
    private boolean isAvailable;

    public Frosting() {
    }

    public Frosting(int frosting_id, String description, BigDecimal cost, int inventoryAmount, boolean isAvailable) {
        this.frosting_id = frosting_id;
        this.description = description;
        this.cost = cost;
        this.inventoryAmount = inventoryAmount;
        this.isAvailable = isAvailable;
    }

    public int getFrosting_id() {
        return frosting_id;
    }

    public void setFrosting_id(int frosting_id) {
        this.frosting_id = frosting_id;
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
