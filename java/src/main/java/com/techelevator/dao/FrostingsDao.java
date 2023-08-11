package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Frosting;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FrostingsDao {
    private final JdbcTemplate jdbcTemplate;

    public FrostingsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Frosting> getListOfFrostings() {
        List<Frosting> frostings = new ArrayList<>();
        String sql ="";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Frosting frosting = mapRowToFrosting(results);
            frostings.add(frosting);
        }
        return frostings;
    }
    public Frosting getFrostingsById(int id) {
        Frosting frosting = null;
        String sql ="";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                frosting = mapRowToFrosting(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return frosting;
    }

    public int toggleAvailabilityOfFrosting(int id){
        int frostingId;

        String sql = "UPDATE frostingsDaos\n" +
                "SET availability = NOT availability\n" +
                "WHERE frostingsDaoid = ?";
        try {
            frostingId = jdbcTemplate.update(sql, id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return frostingId;
    }


    private Frosting mapRowToFrosting(SqlRowSet result) {
        Frosting frosting = new Frosting();
        frosting.setFrosting_id(result.getInt("frostingid"));
        frosting.setDescription(result.getString("description"));
        frosting.setCost(result.getBigDecimal("cost"));
        frosting.setInventoryAmount(result.getInt("inventoryamount"));
        frosting.setAvailable(result.getBoolean("isavailable"));
        return frosting;
    }
}
