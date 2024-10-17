package com.consertreservation.domain.seat.repository;

public interface ReservationSeatReadRepository {
    boolean isReservedSeat(Long seatId, Long userId);
}
