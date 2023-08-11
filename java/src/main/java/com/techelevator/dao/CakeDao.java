package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Cake;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CakeDao {

    private final JdbcTemplate jdbcTemplate;

    public CakeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cake> getListOfStandardCakes() {
        List<Cake> cakes = new ArrayList<>();
        String sql ="SELECT c.CakeID, c.Title, c.Description, c.Price, c.Style,c.Size, f.Description AS Flavor, fr.Description AS Frosting, fi.Description AS Filling, c.isAvailable, c.image\n" +
                "FROM cakes c LEFT JOIN cakes_flavors cf ON c.CakeID = cf.CakeID\n" +
                "LEFT JOIN flavors f ON cf.FlavorID = f.FlavorID\n" +
                "LEFT JOIN cakes_frostings cfr ON c.CakeID = cfr.CakeID\n" +
                "LEFT JOIN frostings fr ON cfr.FrostingID = fr.FrostingID\n" +
                "LEFT JOIN cakes_fillings cfi ON c.CakeID = cfi.CakeID\n" +
                "LEFT JOIN fillings fi ON cfi.FillingID = fi.FillingID";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Cake cake = mapRowToCake(results);
            cakes.add(cake);
        }
        return cakes;
    }
    public Cake getStandardCakeById(int id) {
        Cake cake = null;
        String sql ="SELECT c.CakeID, c.Title, c.Description, c.Price, c.Style,c.Size, f.Description AS Flavor, fr.Description AS Frosting, fi.Description AS Filling, c.isAvailable, c.image\n" +
                "FROM cakes c LEFT JOIN cakes_flavors cf ON c.CakeID = cf.CakeID\n" +
                "LEFT JOIN flavors f ON cf.FlavorID = f.FlavorID\n" +
                "LEFT JOIN cakes_frostings cfr ON c.CakeID = cfr.CakeID\n" +
                "LEFT JOIN frostings fr ON cfr.FrostingID = fr.FrostingID\n" +
                "LEFT JOIN cakes_fillings cfi ON c.CakeID = cfi.CakeID\n" +
                "LEFT JOIN fillings fi ON cfi.FillingID = fi.FillingID\n" +
                "WHERE c.cakeid = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                cake = mapRowToCake(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return cake;
    }

    public Cake addCake(Cake cake){
        Cake newCake = null;
        return newCake;
    }

    public int toggleAvailabilityOfStandardCake(Cake cake){
        int affected;

        String sql = "UPDATE cakes\n" +
                "SET availability = NOT availability\n" +
                "WHERE cakeid = ?";
        try {
            affected = jdbcTemplate.update(sql, cake.getCake_id());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return affected;
    }


    private Cake mapRowToCake(SqlRowSet result) {
        Cake cake = new Cake();
        cake.setCake_id(result.getInt("cakeid"));
        cake.setTitle(result.getString("title"));
        cake.setDescription(result.getString("description"));
        cake.setPrice(result.getBigDecimal("price"));
        cake.setStyle(result.getString("style"));
        cake.setSize(result.getString("size"));
        cake.setFlavor(result.getString("flavor"));
        cake.setFrosting(result.getString("frosting"));
        cake.setFilling(result.getString("filling"));
        cake.setAvailability(result.getBoolean("availability"));
        cake.setImage(result.getString("image"));
        return cake;
    }
}
