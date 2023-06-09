package com.pelin.boxservice.model;

public enum DeliveryStatus {
    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    DELIVERED("Delivered"),
    FAILED("Failed");
    private String status;

    DeliveryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
