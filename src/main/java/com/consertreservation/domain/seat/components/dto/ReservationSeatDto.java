package com.consertreservation.domain.seat.components.dto;

import com.consertreservation.domain.seat.model.ReservationSeat;
import com.consertreservation.domain.seat.model.ReservationSeatStatus;

/**
 * private Long id;
 *
 *     private Long userId;
 *     private Long seatId;
 *     private ReservationSeatStatus status;
 */
public record ReservationSeatDto(
        Long id,
        Long userId,
        Long seatId,
        ReservationSeatStatus status
) {

    public static ReservationSeatDto from(ReservationSeat reservationSeat) {
        return new ReservationSeatDto(reservationSeat.getId(), reservationSeat.getUserId(), reservationSeat.getSeatId(),
                reservationSeat.getStatus());
    }
}
