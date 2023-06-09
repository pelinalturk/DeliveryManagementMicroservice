package com.pelin.boxservice.model;

import com.pelin.boxservice.service.deliverystate.DeliveryStatusState;
import com.pelin.boxservice.service.deliverystate.PendingState;

import java.time.LocalDate;

public class BaseEntity {
    private DeliveryStatus deliveryStatus;
    private LocalDate createdAt;

    public BaseEntity(){
        this.deliveryStatus = DeliveryStatus.PENDING;
        this.createdAt = LocalDate.now();
    }

    public BaseEntity(DeliveryStatus deliveryStatus, LocalDate createdAt) {
        this.deliveryStatus = deliveryStatus;
        this.createdAt = createdAt;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
