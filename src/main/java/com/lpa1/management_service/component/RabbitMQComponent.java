package com.lpa1.management_service.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpa1.management_service.model.OrderModel;
import lombok.Data;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 *The RabbitMQComponent handles communication with RabbitMQ for sending
 * and receiving messages.
 *
 */
@Component
@Data
public class RabbitMQComponent {


    //ArrayList to hold the orders
    private final List<OrderModel> order_list = new ArrayList<>();

    //ObjectMapper to read value from RabbitMQ to convert into Order Model
    @Autowired
    private final ObjectMapper objectMapper;

    /**
     * This function listens to queue, convert the response into a model
     * then add it into the list each time the client send order to the queue
     *
     * @param order represents the order from rabbitmq
     */
    @RabbitListener(queues = "order_queue")
    public void receiveOrder(String order) {
        //Try catch for catching exceptions
        try {

            //Read the value pf tje order which convert into order model
            OrderModel convertedOrder = objectMapper.readValue(order, OrderModel.class);
            //Adds the converted order into the list
            order_list.add(convertedOrder);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Represents the getter for the List of orders
     *
     * @return the List of orders
     */
    public List<OrderModel> getAllOrders() {
        return new ArrayList<OrderModel>(order_list);
    }
}
