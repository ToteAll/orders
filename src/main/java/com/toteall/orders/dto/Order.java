package com.toteall.orders.dto;

import lombok.Data;

@Data
public class Order {
    double basePrice;
    double km;
    double weight;
    double height;
    double width;
}
