package com.consertreservation.domain.concert.components.dto;

import com.consertreservation.domain.concert.model.Concert;
import com.consertreservation.domain.concert.model.ConcertSchedule;
import java.time.LocalDateTime;

public record ConcertWithScheduleDto(
        Long concertId,
        String title,
        Long concertScheduleId,
        LocalDateTime reservationStartDate,
        LocalDateTime concertStartDate,
        LocalDateTime concertEndDate,
        int reservationSeat,
        int remainOfReservationOfSeat
) {
    public static ConcertWithScheduleDto from(ConcertDto concertDto, ConcertScheduleDto concertScheduleDto) {
        return new ConcertWithScheduleDto(concertDto.id(), concertDto.title(), concertScheduleDto.id(),
                concertScheduleDto.reservationStateDate(), concertScheduleDto.concertStartDate(),
                concertScheduleDto.concertEndDate(),
                concertScheduleDto.reservationSeat(), concertScheduleDto.remainOfReservationOfSeat());
    }

    public static ConcertWithScheduleDto of(Concert concert, ConcertSchedule concertSchedule) {
        return new ConcertWithScheduleDto(concert.getId(), concert.getTitle(), concertSchedule.getId(),
                concertSchedule.getReservationStartDate(), concertSchedule.getConcertStartDate(),
                concertSchedule.getConcertEndDate(),
                concertSchedule.getReservationSeat(), concertSchedule.getRemainOfReservationSeat());
    }
}
