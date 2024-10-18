package com.lpa1.management_service.controller;


import com.lpa1.management_service.model.OrderModel;
import com.lpa1.management_service.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;


/**
 * THis controller handles the incoming request to route the request to the endpoint
 */
@RestController
@RequestMapping("/spring_api")
public class ManagementController {

    //Represents an instance of the ManagementService
    @Autowired
    private ManagementService managementService;

    /**
     * Represents the api test endpoint
     *
     * @return returns Testing
     */
    @GetMapping("test")
    public String test(){
        return "Testing";
    }

    /**
     * Represents the endpoint for getOrders, process the order
     *
     * @return Calls the management service
     */
    @GetMapping("orders")
    public ResponseEntity<List<OrderModel>> getOrders(){
            return managementService.getAllOrders();
    }

    /**
     * Represents the endpoint for get specific order
     *
     * @param animal Represents the type of food
     * @return return the specific order
     */
    @GetMapping("orders/food/for={animal}")
    public ResponseEntity<List<OrderModel>> getSpecificOrder( @PathVariable String animal){
        return managementService.getSpecificOrder(animal);
    }

    /**
     * Represents the endpoint for get order by id
     *
     * @param productId represents the product id
     * @return return the order that matches the given product id
     */
    @GetMapping("orders/id={productId}")
    public ResponseEntity<Optional<OrderModel>> getOrderById(@PathVariable String productId){
        return managementService.getOrderById(productId);
    }
}
