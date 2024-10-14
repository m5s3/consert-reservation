package com.consertreservation.api.seat;

import com.consertreservation.api.seat.dto.RequestConcert;
import com.consertreservation.api.seat.dto.RequestReservationSeat;
import com.consertreservation.api.seat.dto.RequestSeatDate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/seat")
public class SeatController {

    @GetMapping("/reservation-date")
    public ResponseEntity showByDate(@RequestHeader String userTokenId, @RequestBody RequestSeatDate request) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/reservation-seat")
    public ResponseEntity showSeatsByConsert(@RequestHeader String userTokenId, @RequestBody RequestConcert request) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reservation")
    public ResponseEntity reserveSeat(@RequestHeader String userTokenId, @RequestBody RequestReservationSeat request) {
        return ResponseEntity.ok().build();
    }
}
