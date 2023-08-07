package com.techelevator.controller;

import com.techelevator.dao.StaffDao;
import com.techelevator.model.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class StaffController {

    private final StaffDao staffDao;

    public StaffController(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @RequestMapping(path = "staff/cakes", method = RequestMethod.GET)
    public List<Cake> listOfStandardCakes() {
        return staffDao.getListOfStandardCakes();
    }

    @RequestMapping(path = "staff/cakes/{id}", method = RequestMethod.GET)
    public Cake getSingleCake(@PathVariable int id) {
        return staffDao.getStandardCakeById(id);
    }
}
