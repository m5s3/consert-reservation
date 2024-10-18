package com.consertreservation.domain.seat.repository;

import com.consertreservation.domain.seat.model.Seat;

public interface SeatStoreRepository {
    Seat save(Seat seat);
}
