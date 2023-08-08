package com.techelevator.controller;

import com.techelevator.dao.CustomerDao;
import com.techelevator.model.Cake;
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

    @RequestMapping(path = "cakes", method = RequestMethod.GET)
    public List<Cake> listOfStandardCakes() {
        return customerDao.getListOfStandardCakes();
    }

    @RequestMapping(path = "cakes/{id}", method = RequestMethod.GET)
    public Cake getSingleCake(@PathVariable int id) {
        return customerDao.getStandardCakeById(id);
    }
}
