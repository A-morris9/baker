package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Flavor;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class FlavorsDao {
    private final JdbcTemplate jdbcTemplate;

    public FlavorsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Flavor> getListOfFlavors() {
        List<Flavor> flavors = new ArrayList<>();
        String sql ="Select * FROM flavors";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Flavor flavor = mapRowToFlavor(results);
            flavors.add(flavor);
        }
        return flavors;
    }
    public Flavor getFlavorsById(int id) {
        Flavor flavor = null;
        String sql ="";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                flavor = mapRowToFlavor(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return flavor;
    }

    public int toggleAvailabilityOfFlavor(int id){
        int flavorId;

        String sql = "UPDATE flavorsDaos\n" +
                "SET availability = NOT availability\n" +
                "WHERE flavorsDaoid = ?";
        try {
            flavorId = jdbcTemplate.update(sql, id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return flavorId;
    }


    private Flavor mapRowToFlavor(SqlRowSet result) {
        Flavor flavor = new Flavor();
        flavor.setFlavor_id(result.getInt("flavorid"));
        flavor.setDescription(result.getString("description"));
        flavor.setCost(result.getBigDecimal("cost"));
        flavor.setInventoryAmount(result.getInt("inventoryamount"));
        flavor.setAvailable(result.getBoolean("isavailable"));
        return flavor;
    }
}
