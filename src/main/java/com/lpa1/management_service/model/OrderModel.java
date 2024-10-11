package com.lpa1.management_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Represents a Order model.
 *
 * This class is a model for orders which includes the product, quantity, and the total Price.
 *
 * Uses Lombok Annotations
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

    //Represents the model of the product
    private ProductModel product;
    //Represents the quantity of the product
    private int quantity;
    //Represents the total price of the product
    private double totalPrice;


}
