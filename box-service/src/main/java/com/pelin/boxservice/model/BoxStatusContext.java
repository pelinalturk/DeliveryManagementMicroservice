package com.pelin.boxservice.model;

import com.pelin.boxservice.service.deliverystate.DeliveryStatusState;

public class BoxStatusContext {
    private DeliveryStatusState state;

    public void setState(DeliveryStatusState state) {
        this.state = state;
    }

    public void handleStatusChange(String boxId) {
        //state.handleStatusChange(boxId);
    }
}
