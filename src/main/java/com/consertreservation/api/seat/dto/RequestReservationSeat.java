package com.consertreservation.api.seat.dto;

public class RequestReservationSeat {

    private final int concertId;
    private final int seatId;

    public RequestReservationSeat(int concertId, int seatId) {
        this.concertId = concertId;
        this.seatId = seatId;
    }
}
