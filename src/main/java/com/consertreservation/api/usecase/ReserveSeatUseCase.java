package com.consertreservation.api.usecase;

import com.consertreservation.api.usecase.dto.ResponseReservationSeat;
import com.consertreservation.domain.concert.components.ConcertScheduleComponent;
import com.consertreservation.domain.concert.components.dto.ConcertScheduleDto;
import com.consertreservation.domain.seat.components.ReservationSeatComponent;
import com.consertreservation.domain.seat.model.ReservationSeat;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReserveSeatUseCase {

    private final ConcertScheduleComponent concertScheduleComponent;
    private final ReservationSeatComponent reservationSeatComponent;

    public ResponseReservationSeat reserveSeat(Long concertId, Long userId, Long seatId, LocalDateTime reserveDate) {
        concertScheduleComponent.isAvailableReservation(concertId, reserveDate);
        return ResponseReservationSeat.from(reservationSeatComponent.reserveSeat(seatId, userId));
    }
}
