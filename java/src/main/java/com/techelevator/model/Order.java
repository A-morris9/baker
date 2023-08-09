package com.techelevator.model;

import org.apache.tomcat.jni.Local;
import org.apache.tomcat.jni.Time;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Order {
    private int order_id;
    private int cake_id;
    private String firstName;
    private String lastName;
    private int streetNumber;
    private String streetName;
    private String city;
    private String state;
    private int zip;
    private String phoneNumber;
    private LocalDateTime orderDate;
    private LocalDateTime pickupDate;
    private String writing;
    private BigDecimal writingFee;
    private BigDecimal totalAmount;

    public Order() {
    }

    public Order(int order_id, int cake_id, String firstName, String lastName, int streetNumber, String streetName,
                 String city, String state, int zip, String phoneNumber, LocalDateTime orderDate, LocalDateTime pickupDate, String writing,
                 BigDecimal writingFee, BigDecimal totalAmount) {
        this.order_id = order_id;
        this.cake_id = cake_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.pickupDate = pickupDate;
        this.writing = writing;
        this.writingFee = writingFee;
        this.totalAmount = totalAmount;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCake_id() {
        return cake_id;
    }

    public void setCake_id(int cake_id) {
        this.cake_id = cake_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = LocalDateTime.now();
    }

    public LocalDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDateTime pickupDate) {
        this.pickupDate = LocalDateTime.now().plusDays(3);
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }

    public BigDecimal getWritingFee() {
        return writingFee;
    }

    public void setWritingFee(BigDecimal writingFee) {
        this.writingFee = writingFee;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}





