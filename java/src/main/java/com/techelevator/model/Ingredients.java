package com.techelevator.model;

import java.math.BigDecimal;

public class Ingredients {
    private int ingredientID;
    private String name;
    private String unitOfMeasure;
    private BigDecimal cost;
    private int stockQuantity;
    private String style;
    private String size;
    private String flavor;
    private String frosting;
    private String filling;
    private Boolean availability;

    public Ingredients() {

    }

    public int getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getFrosting() {
        return frosting;
    }

    public void setFrosting(String frosting) {
        this.frosting = frosting;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Ingredients(int ingredientID, String name, String unitOfMeasure, BigDecimal cost, int stockQuantity, String style,
                       String size, String flavor, String frosting, String filling, Boolean availability) {
        this.ingredientID = ingredientID;
        this.name = name;
        this.unitOfMeasure = unitOfMeasure;
        this.cost = cost;
        this.stockQuantity = stockQuantity;
        this.style = style;
        this.size = size;
        this.flavor = flavor;
        this.frosting = frosting;
        this.filling = filling;
        this.availability = availability;
    }


}
