package com.consertreservation.api.charge.dto;

public class RequestCharge {

    private final int amount;

    public RequestCharge(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
