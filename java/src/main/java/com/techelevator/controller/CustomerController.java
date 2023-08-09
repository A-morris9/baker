package com.techelevator.controller;

import com.techelevator.dao.CustomerDao;
import com.techelevator.model.Cake;
import com.techelevator.model.Order;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.security.Principal;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {

    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    //Gives a full list of all standard cakes that are available for purchase.
    @RequestMapping(path = "cakes", method = RequestMethod.GET)
    public List<Cake> listOfStandardCakes() {
        return customerDao.getListOfStandardCakes();
    }

    //allows a customer to see a full cake model of a single standard cake.
    @RequestMapping(path = "cakes/{id}", method = RequestMethod.GET)
    public Cake getSingleCake(@PathVariable int id) {
        return customerDao.getStandardCakeById(id);
    }

    //allows a customer to create an order for a standard cake. Allows for Optional Writing on the cake.
    @RequestMapping(path = "cakes/order", method = RequestMethod.POST)
    public void orderStandardCake(@RequestBody Order order){
        customerDao.orderStandardCake(order);
    }

    //allows a customer to create an order for a custom cake.
    // Allows for customization of Filling, Frosting, Flavor, and Optional Writing on the cake.
    @RequestMapping(path = "cakes/custom", method = RequestMethod.POST)
    public void orderCustomCake(@RequestBody Order order){

    }



}
