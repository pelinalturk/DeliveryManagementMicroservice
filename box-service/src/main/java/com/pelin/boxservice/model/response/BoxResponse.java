package com.pelin.boxservice.model.response;

import com.pelin.boxservice.model.DeliveryStatus;

import java.time.LocalDate;

public class BoxResponse {
    private int weight;
    private String dimensions;
    private String recipientId;
    private String senderId;
    private DeliveryStatus deliveryStatus;
    private LocalDate createdAt;
}
