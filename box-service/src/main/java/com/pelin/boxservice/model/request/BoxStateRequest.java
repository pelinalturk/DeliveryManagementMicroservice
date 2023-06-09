package com.pelin.boxservice.model.request;

import com.pelin.boxservice.model.DeliveryStatus;

public class BoxStateRequest {
    private DeliveryStatus state;

    public DeliveryStatus getState() {
        return state;
    }

    public void setState(DeliveryStatus state) {
        this.state = state;
    }
}
