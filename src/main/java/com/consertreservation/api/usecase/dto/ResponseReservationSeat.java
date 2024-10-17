package com.consertreservation.api.usecase.dto;

import com.consertreservation.domain.seat.components.dto.ReservationSeatDto;

/**
 * Long id,
 *         Long userId,
 *         Long seatId,
 *         ReservationSeatStatus status
 */
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
