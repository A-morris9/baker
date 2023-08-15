package com.techelevator.dao;

import com.techelevator.model.Flavor;
import com.techelevator.model.Frosting;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;

public class JdbcFrostingsDaoTests extends BaseDaoTests{

    protected static final Frosting FROSTING_1 = new Frosting(1, "chocolate", new BigDecimal(12), 500, true);
    protected static final Frosting FROSTING_2 = new Frosting(2, "vanilla", new BigDecimal(12), 500, true);
    private static final Frosting FROSTING_3 = new Frosting(3, "caramel", new BigDecimal(12), 500, true);

    private FrostingsDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new FrostingsDao(jdbcTemplate);
    }

    @Test
    public void getListOfFrostings_returns_all_available_frostings() {
        List<Frosting> frostings = sut.getListOfFrostings();
        Assert.assertEquals(3, frostings.size());
    }


}
