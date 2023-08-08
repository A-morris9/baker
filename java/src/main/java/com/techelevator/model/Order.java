package com.techelevator.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
private int order_id;
private int cake_id;
private String customerName;
private String deliveryAddress;
private String phoneNumber;
private Date orderDate;
private Date pickupDate;
private Boolean customerWantsWriting;
private String writing;
private BigDecimal writingFee;
private BigDecimal totalAmount;

    public Order() {
    }

    public Order(int order_id, int cake_id, String customerName, String deliveryAddress, String phoneNumber,
                 Date orderDate, Date pickupDate, Boolean customerWantsWriting, String writing,
                 BigDecimal writingFee, BigDecimal totalAmount) {
        this.order_id = order_id;
        this.cake_id = cake_id;
        this.customerName = customerName;
        this.deliveryAddress = deliveryAddress;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.pickupDate = pickupDate;
        this.customerWantsWriting = customerWantsWriting;
        this.writing = writing;
        this.writingFee = writingFee;
        this.totalAmount = totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getCustomerWantsWriting() {
        return customerWantsWriting;
    }

    public void setCustomerWantsWriting(Boolean customerWantsWriting) {
        this.customerWantsWriting = customerWantsWriting;
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
