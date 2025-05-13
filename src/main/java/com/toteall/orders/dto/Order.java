package com.toteall.orders.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String receiverName;
    private String receiverContact;
    private String senderName;
    private String senderContact;
    private String senderEmail;

    private Double distance;
    private Double price;
    private String itemCode;

    private Double height;
    private Double weight;

    private String sourcePostcode;
    private String destinationPostcode;

    private LocalDateTime createdAt = LocalDateTime.now();
}