package com.techelevator.controller;

import com.techelevator.dao.StaffDao;
import com.techelevator.model.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class StaffController {

    private final StaffDao staffDao;

    public StaffController(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    //Gives a staff member a view of all standard cakes that are in the database,
    // regardless of if they are available to customers or not. Returns a partial cake model.
    @RequestMapping(path = "staff/cakes", method = RequestMethod.GET)
    public List<Cake> listOfStandardCakes() {
        return staffDao.getListOfStandardCakes();
    }

    //Gives a staff member a view of a specific standard cake using the cake ID as reference. Returns a full cake model.
    @RequestMapping(path = "staff/cakes/{id}", method = RequestMethod.GET)
    public Cake getSingleCake(@PathVariable int id) {
        return staffDao.getStandardCakeById(id);
    }

    //Gives a staff member the ability to create a new standard cake,
    //allowing for customization of Style, Size, Flavor, Frosting, and Filling, Name, and Price.
    @RequestMapping(path = "staff/create", method = RequestMethod.GET)
    public Cake createStandardCake() {
        return null;
    }

    //Gives a staff member the ability to toggle the availability of a standard cake.
    @RequestMapping(path = "staff/availability/{id}", method = RequestMethod.PUT)
    public void toggleAvailabilityOfStandardCake(@PathVariable int id) {
        Cake cake = staffDao.getStandardCakeById(id);
        staffDao.toggleAvailabilityOfStandardCake(cake);
    }

    //Gives a staff member the ability to see a list of pending orders
    @RequestMapping(path = "staff/orders/pending", method = RequestMethod.GET)
    public List<Cake> listPendingOrders() {
        return null;
    }

    //Gives a staff member the ability to change the status of an order given orderID and status code.
    // 1 = Pending, 2 = Canceled, 3 = Ready, 4 = Complete
    @RequestMapping(path = "staff/orders/changeStatus", method = RequestMethod.GET)
    public Cake changeOrderStatusById(@PathVariable int id,@PathVariable int status) {
        return null;
    }

    //
}
