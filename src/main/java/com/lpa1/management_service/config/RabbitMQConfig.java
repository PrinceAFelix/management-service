package com.lpa1.management_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Configures RabbitMQ for getting messages from a queue with queue name "order_queue".
 *
 */
@Configuration
public class RabbitMQConfig {

    /**
     * Creates and establish a connection with "order_queue" for message handling.
     *
     * @return the Queue
     */
    @Bean
    Queue queue() {
        return new Queue("order_queue", false);
    }
}
