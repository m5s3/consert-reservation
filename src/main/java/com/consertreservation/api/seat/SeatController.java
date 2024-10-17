package com.consertreservation.api.seat;

import com.consertreservation.api.seat.dto.RequestConcert;
import com.consertreservation.api.seat.dto.RequestReservationSeat;
import com.consertreservation.api.seat.dto.RequestSeatDate;
import com.consertreservation.api.usecase.ReserveSeatUseCase;
import com.consertreservation.api.seat.dto.ResponseReservationSeat;
import com.consertreservation.domain.seat.components.dto.ReservationSeatDto;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/seat")
@RequiredArgsConstructor
public class SeatController {

    private final ReserveSeatUseCase reserveSeatUseCase;

    @GetMapping("/reservation-date")
    public ResponseEntity showByDate(@RequestHeader String userTokenId, @RequestBody RequestSeatDate request) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/reservation-seat")
    public ResponseEntity showSeatsByConsert(@RequestHeader String userTokenId, @RequestBody RequestConcert request) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reservation")
    public ResponseEntity<ResponseReservationSeat> reserveSeat(
            @RequestBody RequestReservationSeat request) {
        reserveSeatUseCase.validateReserveSeat(request.seatId(), request.userId(), request.reservationDate());
        return ResponseEntity.ok()
                .body(ResponseReservationSeat.from(reserveSeatUseCase.reserveSeat(request.seatId(), request.userId())));
    }
}
