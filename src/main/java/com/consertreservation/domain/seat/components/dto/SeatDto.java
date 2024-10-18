package com.consertreservation.domain.seat.components.dto;

import com.consertreservation.domain.seat.model.Seat;

public record SeatDto(
        Long id,
        Long concertScheduleId,
        int seatNumber,
        long fee
) {

    public static SeatDto from(Seat seat) {
        return new SeatDto(seat.getId(), seat.getConcertScheduleId(), seat.getSeatNumber(), seat.getFee());
    }
}
