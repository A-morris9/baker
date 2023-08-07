package com.techelevator.model;

import java.math.BigDecimal;

public class Cake {

    private int cake_id;
    private String title;
    private String description;
    private String image;
    private BigDecimal price;
    private Boolean availability;

    public Cake() {
    }

    public Cake(int cake_id, String title, String description, String image, BigDecimal price) {
        this.cake_id = cake_id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public int getCake_id() {
        return cake_id;
    }

    public void setCake_id(int cake_id) {
        this.cake_id = cake_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
