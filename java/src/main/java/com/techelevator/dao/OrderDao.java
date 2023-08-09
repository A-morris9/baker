package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class OrderDao {

    private final JdbcTemplate jdbcTemplate;

    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Order orderStandardCake(Order order) {
        Order newOrder = null;
       String sql = "INSERT INTO orders (cakeid, customerfirstname, customerlastname, streetnumber, streetname, city, state, zip, phonenumber, orderdate," +
               "pickupdate, writing, writingfee, totalamount)" +
               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING orderid;";

        try {
            int newOrderId = jdbcTemplate.queryForObject(sql, int.class, order.getFirstName(),
                    order.getLastName(), order.getStreetNumber(), order.getStreetName(), order.getCity(), order.getState(),
                    order.getZip(), order.getPhoneNumber(), order.getOrderDate(), order.getPickupDate(), order.getWriting(),
                    order.getWritingFee(), order.getTotalAmount());
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

    private Order getOrderById(int id) {
            Order order = null;
            String sql = "select orderid, customerfirstname, customerlastname, streetnumber, streetname, city, state, zip, " +
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
        order.setCake_id(result.getInt("orderid"));
        order.setFirstName(result.getString("firstName"));
        order.setLastName(result.getString("lastName"));
        order.setStreetNumber(result.getInt("streetNumber"));
        order.setStreetName(result.getString("streetName"));
        order.setCity(result.getString("city"));
        order.setState(result.getString("state"));
        order.setZip(result.getInt("zip"));
        order.setPhoneNumber(result.getString("phoneNumber"));
        if (result.getObject("orderDate") != null) {
            order.setOrderDate(result.getDate("orderDate").toLocalDate().atTime(LocalTime.now()));
        }
        if (result.getObject("pickupDate") != null) {
            order.setPickupDate(result.getDate("pickupDate").toLocalDate().atTime(LocalTime.now()));
        }
        order.setWriting(result.getString("writing"));
        order.setWritingFee(result.getBigDecimal("writingFee"));
        order.setTotalAmount(result.getBigDecimal("totalAmount"));
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
