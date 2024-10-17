package com.consertreservation.api.concert.dto;

import com.consertreservation.domain.concert.components.dto.ConcertWithScheduleDto;
import java.time.LocalDateTime;

public record ResponseConcert(
        Long concertId,
        String title,
        Long concertScheduleId,
        LocalDateTime reservationStartDate,
        LocalDateTime concertStartDate,
        LocalDateTime concertEndDate,
        int reservationSeat,
        int remainOfReservationOfSeat
) {

    public static ResponseConcert from(ConcertWithScheduleDto concertWithSchedule) {
        return new ResponseConcert(concertWithSchedule.concertId(), concertWithSchedule.title(),
                concertWithSchedule.concertScheduleId(),
                concertWithSchedule.reservationStartDate(), concertWithSchedule.concertStartDate(),
                concertWithSchedule.concertEndDate(),
                concertWithSchedule.reservationSeat(),
                concertWithSchedule.remainOfReservationOfSeat());
    }
}
