package com.lpa1.management_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Represents a product properties which includes id, product name, and product price
 *
 * Uses Lombok Annotations
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

    //Represents the id of the product
    private int id;
    //Represents the product name
    private String name;
    //Represents the product price
    private double price;
}
