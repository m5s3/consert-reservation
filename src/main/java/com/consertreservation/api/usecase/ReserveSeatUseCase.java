package com.consertreservation.api.usecase;

import com.consertreservation.domain.concert.components.ConcertScheduleComponent;
import com.consertreservation.domain.seat.components.ReservationSeatComponent;
import com.consertreservation.domain.seat.components.dto.ReservationSeatDto;
import com.consertreservation.domain.usertoken.components.UserTokenComponent;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReserveSeatUseCase {

    private final ConcertScheduleComponent concertScheduleComponent;
    private final ReservationSeatComponent reservationSeatComponent;
    private final UserTokenComponent userTokenComponent;

    public ReservationSeatDto reserveSeat(Long seatId, Long userId, Long concertId, LocalDateTime reserveDate) {
        validateReserveSeat(concertId, userId, reserveDate);
        concertScheduleComponent.decreaseRemainOfSeat(concertId);
        return reservationSeatComponent.reserveSeat(seatId, userId);
    }

    private void validateReserveSeat(Long concertId, Long userId, LocalDateTime reserveDate) {
        userTokenComponent.validateAuthorization(userId);
        concertScheduleComponent.validateAvailableReservation(concertId, reserveDate);
    }
}
