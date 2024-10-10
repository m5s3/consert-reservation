package com.consertreservation.api.payment.dto;

public class RequestPayment {

    private int reservationSeatId;

    public RequestPayment(int reservationSeatId) {
        this.reservationSeatId = reservationSeatId;
    }
}
