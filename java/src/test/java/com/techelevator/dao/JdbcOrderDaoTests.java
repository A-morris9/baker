package com.techelevator.dao;

import com.techelevator.model.Cake;
import com.techelevator.model.Flavor;
import com.techelevator.model.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class JdbcOrderDaoTests extends BaseDaoTests{


    protected static final Order ORDER_1 = new Order(1,1, "Pending", "Edward", "Kelly", 123, "Robley", "Cincinnati", "Ohio", 45223, "555-5555", LocalDateTime.now(), LocalDateTime.now().plusDays(3), "blah", new BigDecimal(5), new BigDecimal(25), new BigDecimal(30));
    protected static final Order ORDER_2 = new Order(2,2, "Pending", "Bill", "Clinton", 456, "Pennsylvania", "Washington", "DC", 11111, "555-5555", LocalDateTime.now(), LocalDateTime.now().plusDays(3), "blah", new BigDecimal(5) , new BigDecimal(25), new BigDecimal(30));
    private static final Order ORDER_3 = new Order(3,3, "Pending", "John", "Adams", 789, "Constitution", "Boston", "Massachusetts", 12222, "555-5555", LocalDateTime.now(), LocalDateTime.now().plusDays(3), "blah",new BigDecimal(5) , new BigDecimal(25), new BigDecimal(30));

    private OrderDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new OrderDao(jdbcTemplate);
    }

    @Test
    public void getListOfOrders_returns_all_orders() {
        List<Order> orders = sut.getListOfOrders();
        Assert.assertEquals(3, orders.size());
    }

}
