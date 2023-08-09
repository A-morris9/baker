package com.techelevator.dao;

import com.techelevator.model.Cake;
import com.techelevator.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class OrderDao {

    private final JdbcTemplate jdbcTemplate;

    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void orderStandardCake(Order order) {
       String sql = "INSERT INTO orders (cakeid, firstname, lastname, streetnumber, streetname, state, phonenumber, orderdate," +
               "pickupdate, customerwantswriting, writing, writingfee, totalamount)" +
               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
       jdbcTemplate.update(sql, order.getCake_id(), order.getFirstName(), order.getLastName(), order.getStreetNumber(), order.getStreetName(), order.getState(),
               order.getPhoneNumber(), order.getOrderDate(), order.getPickupDate(), order.getCustomerWantsWriting(), order.getWriting(),
               order.getWritingFee(), order.getTotalAmount());
    }

    private Order mapRowToCake(SqlRowSet result){

    }
}
