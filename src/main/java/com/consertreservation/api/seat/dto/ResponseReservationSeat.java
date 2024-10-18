package com.consertreservation.api.seat.dto;

import com.consertreservation.domain.seat.components.dto.ReservationSeatDto;

public record ResponseReservationSeat(
        Long id,
        Long seatId,
        Long userId,
        String Status
) {

    public static ResponseReservationSeat from(ReservationSeatDto reservationSeatDto) {
        return new ResponseReservationSeat(reservationSeatDto.id(),
                reservationSeatDto.seatId(), reservationSeatDto.userId(), reservationSeatDto.status().name());
    }
}
