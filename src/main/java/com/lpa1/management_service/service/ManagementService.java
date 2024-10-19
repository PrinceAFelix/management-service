package com.lpa1.management_service.service;


import com.lpa1.management_service.component.RabbitMQComponent;
import com.lpa1.management_service.model.OrderModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Management Service class is responsible for handling response.
 * Method getLastReceivedOrder() is used to return the orders to the client
 */
@Service
public class ManagementService {

    //Represents an instance of the RabbitMQComponent
    @Autowired
    RabbitMQComponent rabbitMQ;

    /**
     * This method is responsible for handling the GET request
     *
     * @return the list of all the orders as a Response Entity
     */
    public ResponseEntity<List<OrderModel>> getAllOrders() {
       try{
           return ResponseEntity.ok().body(rabbitMQ.getAllOrders());
       }catch (Exception e){
           return ResponseEntity.notFound().build();
       }
    }

    /**
     * Method responsible for getting specific order
     *
     * @param foodType Represents the type of food
     * @return return the list of orders
     */
    public ResponseEntity<List<OrderModel>> getSpecificOrder(String foodType) {
        try{
            return ResponseEntity.ok().body(rabbitMQ.getSpecificOrder(foodType));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Method for getting order by id
     *
     * @param productId represents the product id
     * @return the order that matches the id
     */
    public ResponseEntity<Optional<OrderModel>> getOrderById(int productId) {
        try{
            return ResponseEntity.ok().body(rabbitMQ.getOrderById(productId));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
