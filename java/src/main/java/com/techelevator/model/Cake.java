package com.techelevator.model;

import java.math.BigDecimal;

public class Cake {

    private int cake_id;
    private String title;
    private String description;
    private BigDecimal price;
    private String style;
    private String size;
    private String flavor;
    private String frosting;
    private String filling;
    private Boolean availability;
    private String image;


    public Cake() {
    }

    public Cake(int cake_id, String title, String description, BigDecimal price, String style, String size, Boolean availability, String image, String flavor, String frosting, String filling) {
        this.cake_id = cake_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.style = style;
        this.size = size;
        this.flavor = flavor;
        this.frosting = frosting;
        this.filling = filling;
        this.availability = availability;
        this.image = image;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

