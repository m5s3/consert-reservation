package com.consertreservation.domain.seat.infra;

import com.consertreservation.domain.seat.model.ReservationSeat;
import com.consertreservation.domain.seat.repository.ReservationSeatStoreRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationSeatJPARepository extends JpaRepository<ReservationSeat, Long>,
        ReservationSeatStoreRepository {

}
