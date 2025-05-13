package com.toteall.orders.api;

import com.toteall.orders.dto.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {

    @PostMapping("estimate")
    public double estimate(@RequestBody Order order) {
        double basePricePerKm = order.getBasePrice();
        double weightCharge = 1.5;
        double sizeCharge = 0.05;

        double distanceCost = basePricePerKm * order.getKm();
        double weightCost = weightCharge * order.getWeight();
        double sizeCost = sizeCharge * order.getHeight() * order.getWidth();

        return distanceCost + weightCost + sizeCost;
    }
}
