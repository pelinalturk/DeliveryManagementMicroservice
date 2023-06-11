package com.pelin.boxservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("boxes")
public class Box extends BaseEntity{
    @Id
    private String id;
    private String recipientId;
    private String senderId;
    private int weight;
    private String dimensions;

    public Box(){}

    public Box(DeliveryStatus deliveryStatus, LocalDate createdAt, String id, String recipientId, String senderId, int weight, String dimensions) {
        super(deliveryStatus, createdAt);
        this.id = id;
        this.recipientId = recipientId;
        this.senderId = senderId;
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
