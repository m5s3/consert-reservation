package com.consertreservation.domain.seat.repository;

import com.consertreservation.domain.seat.model.Seat;

public interface SeatReaderRepository {
    Seat getSeat(Long id);
}
