package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Cake;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    public int addCustomCake(Cake cake){
        int newCakeId = 0;
        String sql = "INSERT INTO cakes (title, description, price, style, image)" +
                "VALUES (?, ?, ?, ?, ?) RETURNING cakeid;";
        try {
            newCakeId = jdbcTemplate.queryForObject(sql, int.class, cake.getTitle(), cake.getDescription(),
                    cake.getPrice(), cake.getStyle(), cake.getImage());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newCakeId;
    }






    public int addStandardCake(Cake cake){
        int newCakeId = 0;
        String sql = "INSERT INTO cakes (title, description, price, style, image)" +
                "VALUES (?, ?, ?, ?, ?) RETURNING cakeid;";
        try {
            newCakeId = jdbcTemplate.queryForObject(sql, int.class, cake.getTitle(), cake.getDescription(),
                    cake.getPrice(), cake.getStyle(), cake.getImage());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newCakeId;
    }

    public void addFlavor(Cake cake, int cakeId) {

        String flavor = cake.getFlavor();
        int flavorId = Integer.parseInt(flavor);
        String sql = "INSERT INTO cakes_flavors (CakeID, FlavorID)\n" +
                "VALUES (?, ?);\n";

        try {
            jdbcTemplate.update(sql, cakeId, flavorId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    public void addFrosting(Cake cake, int cakeId) {
        String frosting = cake.getFrosting();
        int frostingId = Integer.parseInt(frosting);

        String sql = "INSERT INTO cakes_frostings (CakeID, FrostingID)\n" +
                "VALUES (?, ?);\n";


        try {
            jdbcTemplate.update(sql, cakeId, frostingId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    public void addFilling(Cake cake, int cakeId) {
        String filling = cake.getFilling();
        int fillingId = Integer.parseInt(filling);
        String sql = "INSERT INTO cakes_fillings (CakeID, FillingID)\n" +
                "VALUES (?, ?);\n";

        try {
            jdbcTemplate.update(sql, cakeId, fillingId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    public void toggleAvailabilityOfStandardCake(int id){


        String sql = "UPDATE cakes\n" +
                "SET isavailable = NOT isavailable\n" +
                "WHERE cakeid = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
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
        cake.setAvailability(result.getBoolean("isavailable"));
        cake.setImage(result.getString("image"));
        return cake;
    }


}
