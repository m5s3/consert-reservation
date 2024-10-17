package com.consertreservation.domain.concert.components.dto;

import com.consertreservation.domain.concert.model.ConcertSchedule;
import java.time.LocalDateTime;

public record ConcertScheduleDto(
        Long id,
        Long concertId,
        LocalDateTime reservationStateDate,
        LocalDateTime concertStartDate,
        LocalDateTime concertEndDate,
        int reservationSeat,
        int remainOfReservationOfSeat
) {

    public static ConcertScheduleDto from(ConcertSchedule concertSchedule) {
        return new ConcertScheduleDto(concertSchedule.getId(), concertSchedule.getConcertId(),
                concertSchedule.getReservationStartDate(), concertSchedule.getConcertStartDate(),
                concertSchedule.getConcertEndDate(), concertSchedule.getReservationSeat(),
                concertSchedule.getRemainOfReservationSeat());
    }
}
