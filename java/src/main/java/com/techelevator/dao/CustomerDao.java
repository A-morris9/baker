package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Cake;
import com.techelevator.model.Order;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDao{

    private final JdbcTemplate jdbcTemplate;

    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cake> getListOfStandardCakes() {
            List<Cake> cakes = new ArrayList<>();
            String sql = "SELECT cakeid, title, description, price, style, size, availability, image FROM cakes";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Cake cake = mapRowToCake(results);
                cakes.add(cake);
            }
            return cakes;
    }
    public Cake getStandardCakeById(int id) {
        Cake cake = null;
        String sql ="SELECT c.CakeID, c.Title, c.Description, c.Price, c.Style,c.Size, f.Name AS Flavor, fr.Name AS Frosting, fi.Name AS Filling, c.availability, c.image\n" +
                "FROM cakes c LEFT JOIN cake_flavors cf ON c.CakeID = cf.CakeID\n" +
                "LEFT JOIN flavors f ON cf.FlavorID = f.FlavorID\n" +
                "LEFT JOIN cakes_frostings cfr ON c.CakeID = cfr.CakeID\n" +
                "LEFT JOIN frostings fr ON cfr.FrostingID = fr.FrostingID\n" +
                "LEFT JOIN cakes_fillings cfi ON c.CakeID = cfi.CakeID\n" +
                "LEFT JOIN fillings fi ON cfi.FillingID = fi.FillingID\n" +
                "WHERE c.cakeid = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                cake = mapRowToCakeDetails(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return cake;
    }
   // public void orderStandardCake(Order order) {
     //   String sql = "INSERT INTO orders (orderid, cakeid, customername, deliveryaddress, phonenumber, orderdate," +
       //         "pickupdate, customerwantswriting, writing, writingfee, totalamount)" +
      //          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
      //  jdbcTemplate.update(sql, order.getOrder_id(), order.getCake_id(), order.getCustomerName(), order.getDeliveryAddress(),
      //          order.getPhoneNumber(), order.getOrderDate(), order.getPickupDate(), order.getCustomerWantsWriting(), order.getWriting(),
       //         order.getWritingFee(), order.getTotalAmount());
   // }



    private Cake mapRowToCakeDetails(SqlRowSet result) {
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


    private Cake mapRowToCake(SqlRowSet result){
        Cake cake = new Cake();
        cake.setCake_id(result.getInt("cakeid"));
        cake.setTitle(result.getString("title"));
        cake.setDescription(result.getString("description"));
        cake.setPrice(result.getBigDecimal("price"));
        cake.setStyle(result.getString("style"));
        cake.setSize(result.getString("size"));
        cake.setAvailability(result.getBoolean("availability"));
        cake.setImage(result.getString("image"));
        return cake;
    }
}
