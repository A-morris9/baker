package com.techelevator.model;

import java.math.BigDecimal;

public class Flavor {
    private int flavor_id;
    private String description;
    private BigDecimal cost;
    private int inventoryAmount;
    private boolean isAvailable;

    public Flavor() {
    }

    public Flavor(int flavor_id, String description, BigDecimal cost, int inventoryAmount, boolean isAvailable) {
        this.flavor_id = flavor_id;
        this.description = description;
        this.cost = cost;
        this.inventoryAmount = inventoryAmount;
        this.isAvailable = isAvailable;
    }

    public int getFlavor_id() {
        return flavor_id;
    }

    public void setFlavor_id(int flavor_id) {
        this.flavor_id = flavor_id;
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
