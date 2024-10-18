package com.consertreservation.api.seat.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record RequestReservationSeat(
        Long seatId,
        Long userId,
        Long concertId,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        LocalDateTime reservationDate
) {
}
