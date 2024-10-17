package com.consertreservation.domain.concert.components.dto;

import java.time.LocalDateTime;

public record ConcertWithScheduleDto(
        Long concertId,
        String title,
        Long concertScheduleId,
        LocalDateTime reservationStateDate,
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
}
