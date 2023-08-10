package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class OrderDao {

    private final JdbcTemplate jdbcTemplate;

    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Order createStandardOrder(Order order) {
        Order newOrder = null;
       String sql = "INSERT INTO orders (cakeid, customerfirstname, customerlastname, streetnumber, streetname, city, state, zip, phonenumber, orderdate," +
               "pickupdate, writing, writingfee, totalamount)" +
               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING orderid;";

        LocalDateTime orderDate = LocalDateTime.now();
        //TO DO: Add deliverydate as a database default
        LocalDateTime deliveryDate = orderDate.plusDays(3);
        BigDecimal writingFee = new BigDecimal(5);
        BigDecimal totalPrice = order.getPrice().add(writingFee);

        try {
            int newOrderId = jdbcTemplate.queryForObject(sql, int.class, order.getCake_id(), order.getFirstName(),
                    order.getLastName(), order.getStreetNumber(), order.getStreetName(), order.getCity(), order.getState(),
                    order.getZip(), order.getPhoneNumber(), orderDate, deliveryDate, order.getWriting(),
                    writingFee, totalPrice);
            newOrder = getOrderById(newOrderId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newOrder;






//       jdbcTemplate.update(sql, order.getorder_id(), order.getFirstName(), order.getLastName(), order.getStreetNumber(), order.getStreetName(), order.getCity(), order.getState(),
//               order.getZip(), order.getPhoneNumber(), order.getOrderDate(), order.getPickupDate(), order.getWriting(),
//               order.getWritingFee(), order.getTotalAmount());
//       return 0;
    }

    public Order getOrderById(int id) {
            Order order = null;
            String sql = "select orderid, cakeid, status, customerfirstname, customerlastname, streetnumber, streetname, city, state, zip, " +
                    "phonenumber, orderdate,pickupdate, writing, writingfee, totalamount FROM Orders WHERE orderid = ?;";
            try {
                SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
                if (results.next()) {
                    order = mapRowToOrder(results);
                }
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            } catch (BadSqlGrammarException e) {
                throw new DaoException("SQL syntax error", e);
            }
            return order;
        }

    private Order mapRowToOrder(SqlRowSet result){
        Order order = new Order();
        order.setOrder_id(result.getInt("orderid"));
        order.setCake_id(result.getInt("cakeid"));
        order.setStatus(result.getString("status"));
        order.setFirstName(result.getString("customerfirstname"));
        order.setLastName(result.getString("customerlastname"));
        order.setStreetNumber(result.getInt("streetnumber"));
        order.setStreetName(result.getString("streetname"));
        order.setCity(result.getString("city"));
        order.setState(result.getString("state"));
        order.setZip(result.getInt("zip"));
        order.setPhoneNumber(result.getString("phonenumber"));
        if (result.getObject("orderdate") != null) {
            order.setOrderDate(result.getDate("orderdate").toLocalDate().atTime(LocalTime.now()));
        }
        if (result.getObject("pickupdate") != null) {
            order.setPickupDate(result.getDate("pickupdate").toLocalDate().atTime(LocalTime.now()));
        }
        order.setWriting(result.getString("writing"));
        order.setWritingFee(result.getBigDecimal("writingfee"));
        order.setTotalAmount(result.getBigDecimal("totalamount"));
        return order;

        //this.order_id = order_id;
        //        this.cake_id = cake_id;
        //        this.firstName = firstName;
        //        this.lastName = lastName;
        //        this.streetNumber = streetNumber;
        //        this.streetName = streetName;
        //        this.city = city;
        //        this.state = state;
        //        this.zip = zip;
        //        this.phoneNumber = phoneNumber;
        //        this.orderDate = orderDate;
        //        this.pickupDate = pickupDate;
        //        this.writing = writing;
        //        this.writingFee = writingFee;
        //        this.totalAmount = totalAmount;

    }
}
