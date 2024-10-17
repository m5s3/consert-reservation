package com.consertreservation.domain.seat.repository;

import com.consertreservation.domain.seat.model.ReservationSeat;

public interface ReservationSeatStoreRepository {

    ReservationSeat save(ReservationSeat reservationSeat);
}
