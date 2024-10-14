package com.consertreservation.api.seat.dto;

import java.time.LocalDateTime;

public class RequestSeatDate {
    private LocalDateTime date;

    public RequestSeatDate(LocalDateTime date) {
        this.date = date;
    }
}
