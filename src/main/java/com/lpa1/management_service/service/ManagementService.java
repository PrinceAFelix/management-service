package com.lpa1.management_service.service;


import com.lpa1.management_service.component.RabbitMQComponent;
import com.lpa1.management_service.model.OrderModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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
    public ResponseEntity<List<OrderModel>> getLastReceivedOrder() {
       try{
           return ResponseEntity.ok().body(rabbitMQ.getAllOrders());
       }catch (Exception e){
           return ResponseEntity.notFound().build();
       }
    }
}
