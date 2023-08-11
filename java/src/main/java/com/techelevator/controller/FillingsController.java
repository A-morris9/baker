package com.techelevator.controller;

import com.techelevator.dao.CakeDao;
import com.techelevator.dao.FillingsDao;
import com.techelevator.model.Cake;
import com.techelevator.model.Filling;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class FillingsController {
    private final FillingsDao fillingsDao;

    public FillingsController(FillingsDao fillingsDao) {
        this.fillingsDao = fillingsDao;
    }

    @RequestMapping(path = "fillings", method = RequestMethod.GET)
    public List<Filling> listOfFillings() {
        return fillingsDao.getListOfFillings();
    }

    //allows a user to see a full cake model of a single standard cake.
    @RequestMapping(path = "fillings/{id}", method = RequestMethod.GET)
    public Filling getSingleFilling(@PathVariable int id) {
        return fillingsDao.getFillingsById(id);
    }

    //Gives a staff member the ability to toggle the availability of a standard cake.
    @RequestMapping(path = "fillings/availability/{id}", method = RequestMethod.PUT)
    public void toggleAvailabilityOfCake(@PathVariable int id) {
        fillingsDao.toggleAvailabilityOfFilling(id);
    }


}
