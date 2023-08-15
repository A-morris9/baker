package com.techelevator.dao;

import com.techelevator.model.Cake;
import com.techelevator.model.Flavor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;

public class JdbcFlavorsDaoTests extends BaseDaoTests{

    protected static final Flavor FLAVOR_1 = new Flavor(1, "chocolate", new BigDecimal(12), 500, true);
    protected static final Flavor FLAVOR_2 = new Flavor(2, "vanilla", new BigDecimal(12), 500, true);
    private static final Flavor FLAVOR_3 = new Flavor(3, "caramel", new BigDecimal(12), 500, true);

    private FlavorsDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new FlavorsDao(jdbcTemplate);
    }

    @Test
    public void getListOfFlavors_returns_all_available_cakes() {
        List<Flavor> flavors = sut.getListOfFlavors();
        Assert.assertEquals(3, flavors.size());
    }

}
