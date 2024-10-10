package com.consertreservation.api.charge.dto;

import lombok.Data;

public class ResponseCharge {

    private final int amount;

    public ResponseCharge(int amount) {
        this.amount = amount;
    }
}
