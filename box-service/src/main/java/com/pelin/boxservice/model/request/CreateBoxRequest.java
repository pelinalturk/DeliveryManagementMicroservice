package com.pelin.boxservice.model.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pelin.boxservice.model.DeliveryStatus;
import com.pelin.boxservice.service.deliverystate.DeliveryStatusState;
import com.pelin.boxservice.service.deliverystate.PendingState;

import java.time.LocalDate;

public class CreateBoxRequest {
    private int weight;
    private String dimensions;
    private String recipientId;
    private String senderId;
    @JsonIgnore
    private DeliveryStatusState deliveryStatus = new PendingState();
    @JsonIgnore
    private LocalDate createdAt = LocalDate.now();

    public CreateBoxRequest(){}

    public CreateBoxRequest(int weight, String dimensions, String recipientId, String senderId) {
        this.recipientId = recipientId;
        this.senderId = senderId;
        this.deliveryStatus = new PendingState();
        this.createdAt=LocalDate.now();
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public DeliveryStatusState getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatusState deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
}
