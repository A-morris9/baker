package com.techelevator.dao;

import com.techelevator.model.Cake;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import com.techelevator.dao.CakeDao;
import org.springframework.jdbc.core.JdbcTemplate;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcCakeDaoTests extends BaseDaoTests {

    protected static final Cake Cake_1 = new Cake(1, "Mercury", "closest to the sun", new BigDecimal(24), "sheet", "large", true, "url", "chocolate", "buttercream", "cherry");
    protected static final Cake Cake_2 = new Cake(2, "Venus", "hottest planet", new BigDecimal(21), "layer", "medium", true, "url", "strawberry", "ganache", "white chocolate");
    private static final Cake Cake_3 = new Cake(3, "Mars", "the red planet", new BigDecimal(22),"cupcakes", "small", false, "url", "vanilla", "chocolate ganache", "caramel");

    private CakeDao sut;
    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new CakeDao(jdbcTemplate);
    }

    @Test
    public void getStandardCakes_returns_all_available_cakes() {
        List<Cake> cakes = sut.getListOfStandardCakes();
        Assert.assertEquals(2, cakes.size());
    }
}
