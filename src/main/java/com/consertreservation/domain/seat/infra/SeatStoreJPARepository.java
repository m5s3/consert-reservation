package com.consertreservation.domain.seat.infra;

import com.consertreservation.domain.seat.model.Seat;
import com.consertreservation.domain.seat.repository.SeatStoreRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatStoreJPARepository extends JpaRepository<Seat, Long>, SeatStoreRepository {

}
