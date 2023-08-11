package com.techelevator.controller;

import com.techelevator.dao.CakeDao;
import com.techelevator.dao.FrostingsDao;
import com.techelevator.model.Cake;
import com.techelevator.model.Filling;
import com.techelevator.model.Frosting;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FrostingsController {
    private final FrostingsDao frostingsDao;

    public FrostingsController(FrostingsDao frostingsDao) {
        this.frostingsDao = frostingsDao;
    }
    @RequestMapping(path = "frostings", method = RequestMethod.GET)
    public List<Frosting> listOfFillings() {
        return frostingsDao.getListOfFrostings();
    }

    //allows a user to see a full cake model of a single standard cake.
    @RequestMapping(path = "frostings/{id}", method = RequestMethod.GET)
    public Frosting getSingleFrosting(@PathVariable int id) {
        return frostingsDao.getFrostingsById(id);
    }

    //Gives a staff member the ability to toggle the availability of a standard cake.
    @RequestMapping(path = "frostings/availability/{id}", method = RequestMethod.PUT)
    public void toggleAvailabilityOfCake(@PathVariable int id) {
        frostingsDao.toggleAvailabilityOfFrosting(id);
    }
}
