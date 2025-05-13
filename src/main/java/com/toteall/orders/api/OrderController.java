package com.toteall.orders.api;

import com.toteall.orders.dto.EstimatedOrder;
import com.toteall.orders.dto.Order;
import com.toteall.orders.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @PostMapping("estimate")
    public double estimate(@RequestBody EstimatedOrder estimatedOrder) {
        double basePricePerKm = estimatedOrder.getBasePrice();
        double weightCharge = 1.5;
        double sizeCharge = 0.05;

        double distanceCost = basePricePerKm * estimatedOrder.getKm();
        double weightCost = weightCharge * estimatedOrder.getWeight();
        double sizeCost = sizeCharge * estimatedOrder.getHeight() * estimatedOrder.getWidth();

        return distanceCost + weightCost + sizeCost;
    }

    @PostMapping("place-order")
    public Long createOrder(@RequestBody Order order) {
        return orderRepository.save(order).getId();
    }
}
