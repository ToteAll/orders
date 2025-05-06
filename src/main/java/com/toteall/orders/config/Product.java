package com.toteall.orders.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "products")
public class Product {
    private String name;
    private double deliveryCharge;

}