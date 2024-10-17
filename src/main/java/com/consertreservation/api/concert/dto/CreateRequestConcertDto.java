package com.consertreservation.api.concert.dto;

import java.time.LocalDateTime;

public record CreateRequestConcertDto(
        String title,
        LocalDateTime reservationStateDate,
        LocalDateTime concertStartDate,
        LocalDateTime concertEndDate,
        int reservationSeat,
        int remainOfReservationOfSeat
) {
}
