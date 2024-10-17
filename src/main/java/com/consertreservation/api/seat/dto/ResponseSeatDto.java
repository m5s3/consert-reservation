package com.consertreservation.api.seat.dto;

import com.consertreservation.domain.seat.components.dto.SeatDto;

public record ResponseSeatDto(
        Long id,
        int seatNumber,
        long fee
) {

    public static ResponseSeatDto from(SeatDto seat) {
        return new ResponseSeatDto(seat.id(), seat.seatNumber(), seat.fee());
    }
}
