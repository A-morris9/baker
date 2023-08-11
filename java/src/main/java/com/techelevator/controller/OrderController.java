package com.techelevator.controller;

import com.techelevator.dao.CakeDao;
import com.techelevator.dao.OrderDao;
import com.techelevator.model.Cake;
import com.techelevator.model.Order;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
    private final OrderDao orderDao;

    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    //allows a customer to create an order for a standard cake. Allows for Optional Writing on the cake.

 //   LocalDateTime now = LocalDateTime.now();
//    Order testOrder = new Order( 1001,1, "Jo", "Shmoe",123,"Lan Ave",
//            "Norwood", "OH", 45245, "123-345-5678", now, now.plusDays(3), "Happy Birthday",
//            BigDecimal.valueOf(5),BigDecimal.valueOf(30));

    @RequestMapping(path = "orders", method = RequestMethod.GET)
    public List<Order> listOfOrders() {
        return orderDao.getListOfOrders();
    }
    @RequestMapping(path = "orders/standard", method = RequestMethod.POST)
    public Order createStandardOrder(@RequestBody Order order){
        //
        return orderDao.createStandardOrder(order);
    }

    //allows a customer to create an order for a custom cake.
    // Allows for customization of Filling, Frosting, Flavor, and Optional Writing on the cake.
    @RequestMapping(path = "orders/custom", method = RequestMethod.POST)
    public void createCustomOrder(@RequestBody Order order){

    }

    //Gives a staff member the ability to see a list of pending orders
    @RequestMapping(path = "orders/pending", method = RequestMethod.GET)
    public List<Order> listPendingOrders() {
        return null;
    }

    //Gives a staff member the ability to change the status of an order given orderID and status code.
    // 1 = Pending, 2 = Canceled, 3 = Ready,
    @RequestMapping(path = "orders/changeStatus/{id}", method = RequestMethod.GET)
    public Order changeOrderStatusById(@PathVariable int id, @PathVariable int status) {
        return null;
    }

    @RequestMapping(path = "orders/{id}", method = RequestMethod.GET)
    public Order getSingleCake(@PathVariable int id) {
        return orderDao.getOrderById(id);
    }
}
