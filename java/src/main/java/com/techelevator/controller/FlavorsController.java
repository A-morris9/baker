package com.techelevator.controller;

import com.techelevator.dao.CakeDao;
import com.techelevator.dao.FlavorsDao;
import com.techelevator.model.Cake;
import com.techelevator.model.Filling;
import com.techelevator.model.Flavor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FlavorsController {
    private final FlavorsDao flavorsDao;

    public FlavorsController(FlavorsDao flavorsDao) {
        this.flavorsDao = flavorsDao;
    }
    @RequestMapping(path = "flavors", method = RequestMethod.GET)
    public List<Flavor> listOfFlavors() {
        return flavorsDao.getListOfFlavors();
    }

    //allows a user to see a full cake model of a single standard cake.
    @RequestMapping(path = "flavors/{id}", method = RequestMethod.GET)
    public Flavor getSingleFlavor(@PathVariable int id) {
        return flavorsDao.getFlavorsById(id);
    }

    //Gives a staff member the ability to toggle the availability of a standard cake.
    @RequestMapping(path = "flavors/availability/{id}", method = RequestMethod.PUT)
    public void toggleAvailabilityOfCake(@PathVariable int id) {
        flavorsDao.toggleAvailabilityOfFlavor(id);
    }
}
