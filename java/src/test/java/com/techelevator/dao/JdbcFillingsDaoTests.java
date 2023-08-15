package com.techelevator.dao;

import com.techelevator.model.Cake;
import com.techelevator.model.Filling;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import com.techelevator.exception.DaoException;
import com.techelevator.model.RegisterUserDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

public class JdbcFillingsDaoTests extends BaseDaoTests{

    protected static final Filling FILLING_1 = new Filling(1, "chocolate", new BigDecimal(12), 500, true);
    protected static final Filling FILLING_2 = new Filling(2, "vanilla", new BigDecimal(12), 500, true);
    private static final Filling FILLING_3 = new Filling(3, "caramel", new BigDecimal(12), 500, true);

    private FillingsDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new FillingsDao(jdbcTemplate);
    }
    @Test
    public void getFillingById_given_valid_filling_id_returns_filling() {
        List<Filling> fillings = sut.getListOfFillings();
        Assert.assertEquals(3, fillings.size());
    }




}
