package com.techelevator.controller;

import com.techelevator.dao.CakeDao;
import com.techelevator.model.Cake;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CakeController {
    private final CakeDao cakeDao;

    public CakeController(CakeDao cakeDao) {
        this.cakeDao = cakeDao;
    }

    //Gives a full list of all standard cakes.
    @RequestMapping(path = "cakes", method = RequestMethod.GET)
    public List<Cake> listOfStandardCakes() {
        return cakeDao.getListOfStandardCakes();
    }

    //allows a user to see a full cake model of a single standard cake.
    @RequestMapping(path = "cakes/{id}", method = RequestMethod.GET)
    public Cake getSingleCake(@PathVariable int id) {
        return cakeDao.getStandardCakeById(id);
    }

    //Gives a staff member the ability to toggle the availability of a standard cake.
    @RequestMapping(path = "cakes/availability/{id}", method = RequestMethod.PUT)
    public void toggleAvailabilityOfCake(@PathVariable int id) {
        cakeDao.toggleAvailabilityOfStandardCake(id);
    }

    //Gives a staff member the ability to create a new standard cake,
    //allowing for customization of Style, Size, Flavor, Frosting, and Filling, Name, and Price.
    @RequestMapping(path = "cakes/custom", method = RequestMethod.POST)
    public Cake addCustomCake(@RequestBody Cake cake) {
        return cakeDao.addCustomCake(cake);
    }

    @RequestMapping(path = "cakes/standard", method = RequestMethod.POST)
    public Cake addStandardCake(@RequestBody Cake cake) {
        return cakeDao.addStandardCake(cake);
    }
}
