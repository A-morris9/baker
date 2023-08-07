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
public class StaffDao{

    private final JdbcTemplate jdbcTemplate;

    public StaffDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cake> getListOfStandardCakes() {
        List<Cake> cakes = new ArrayList<>();
        String sql = "SELECT cakeid, name, description, price, availability FROM cakes";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Cake cake = mapRowToCake(results);
            cakes.add(cake);
        }
        return cakes;
    }
   public Cake getStandardCakeById(int id) {
       Cake cake = null;
       String sql = "SELECT cakeid, name, description, price, availability FROM cakes" +
               " WHERE cakeid=?";
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

   public int addStandardCake(){
        return 0;
   }

    private Cake mapRowToCake(SqlRowSet result){
        Cake cake = new Cake();
        cake.setCake_id(result.getInt("cakeid"));
        cake.setTitle(result.getString("name"));
        cake.setDescription(result.getString("description"));
        cake.setPrice(result.getBigDecimal("price"));
        cake.setAvailability(result.getBoolean("availability"));
        return cake;
    }
}
