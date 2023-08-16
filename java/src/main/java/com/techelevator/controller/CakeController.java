package com.techelevator.controller;

import com.techelevator.dao.CakeDao;
import com.techelevator.model.Cake;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class CakeController {
    private final CakeDao cakeDao;

    public CakeController(CakeDao cakeDao) {
        this.cakeDao = cakeDao;
    }
    //Gives a full list of all standard cakes.
    @PreAuthorize("permitAll")
    @RequestMapping(path = "cakes", method = RequestMethod.GET)
    public List<Cake> listOfStandardCakes() {
        return cakeDao.getListOfStandardCakes();
    }
    @PreAuthorize("permitAll")
    @RequestMapping(path = "cakes/all", method = RequestMethod.GET)
    public List<Cake> listOfAllStandardCakes() {
        return cakeDao.getListOfAllStandardCakes();
    }

    //allows a user to see a full cake model of a single standard cake.
    @PreAuthorize("permitAll")
    @RequestMapping(path = "cakes/{id}", method = RequestMethod.GET)
    public Cake getSingleCake(@PathVariable int id) {
        return cakeDao.getStandardCakeById(id);
    }

    //Gives a staff member the ability to toggle the availability of a standard cake.
    @PreAuthorize("permitAll")
    @RequestMapping(path = "cakes/availability/{id}", method = RequestMethod.PUT)
    public void toggleAvailabilityOfCake(@PathVariable int id) {
        cakeDao.toggleAvailabilityOfStandardCake(id);
    }
    //Gives a staff member the ability to mark a cake as deleted
    @RequestMapping(path = "cakes/deleted/{id}", method = RequestMethod.PUT)
    public void toggleDeletedStatusOfStandardCake(@PathVariable int id) {
        cakeDao.toggleDeletedStatusOfStandardCake(id);
    }

    //Gives a staff member the ability to create a new standard cake,
    //allowing for customization of Style, Size, Flavor, Frosting, and Filling, Name, and Price.
    @PreAuthorize("permitAll")
    @RequestMapping(path = "cakes/custom", method = RequestMethod.POST)
    public Cake addCustomCake(@RequestBody Cake cake) {
        Cake newCake = new Cake();
        int cakeId = 0;
        cakeId = cakeDao.addCustomCake(cake);
        cakeDao.addFlavor(cake, cakeId);
        cakeDao.addFrosting(cake, cakeId);
        cakeDao.addFilling(cake, cakeId);
        newCake = cakeDao.getStandardCakeById(cakeId);
        return newCake;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "cakes/standard", method = RequestMethod.POST)
    public void addStandardCake(@RequestBody Cake cake) {
        int cakeId = cakeDao.addStandardCake(cake);
        cakeDao.addFlavor(cake, cakeId);
        cakeDao.addFrosting(cake, cakeId);
        cakeDao.addFilling(cake, cakeId);
    }
}
