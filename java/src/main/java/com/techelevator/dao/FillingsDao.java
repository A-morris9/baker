package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Filling;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FillingsDao {
    private final JdbcTemplate jdbcTemplate;

    public FillingsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Filling> getListOfFillings() {
        List<Filling> fillings = new ArrayList<>();
        String sql ="Select * FROM fillings";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Filling filling = mapRowToFilling(results);
            fillings.add(filling);
        }
        return fillings;
    }
    public Filling getFillingsById(int id) {
        Filling filling = null;
        String sql ="";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                filling = mapRowToFilling(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return filling;
    }

    public int toggleAvailabilityOfFilling(int id){
        int fillingId;

        String sql = "UPDATE FillingsDaos\n" +
                "SET availability = NOT availability\n" +
                "WHERE FillingsDaoid = ?";
        try {
            fillingId = jdbcTemplate.update(sql, id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return fillingId;
    }


    private Filling mapRowToFilling(SqlRowSet result) {
        Filling filling = new Filling();
        filling.setFilling_id(result.getInt("fillingid"));
        filling.setDescription(result.getString("description"));
        filling.setCost(result.getBigDecimal("cost"));
        filling.setInventoryAmount(result.getInt("inventoryamount"));
        filling.setAvailable(result.getBoolean("isavailable"));
        return filling;
    }
}
