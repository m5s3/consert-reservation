package com.consertreservation.api.concert;

import com.consertreservation.api.concert.dto.CreateRequestConcertDto;
import com.consertreservation.api.concert.dto.ResponseConcert;
import com.consertreservation.api.usecase.ConcertUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/concert")
@RequiredArgsConstructor
public class ConcertController {

    private final ConcertUseCase concertUseCase;

    @PostMapping
    public ResponseEntity<ResponseConcert> createConcert(@RequestBody CreateRequestConcertDto request) {
        return ResponseEntity.ok().body(ResponseConcert.from(concertUseCase.createConcert(
                request.title(),
                request.reservationStateDate(),
                request.concertStartDate(),
                request.concertEndDate(),
                request.reservationSeat()
        )));
    }
}
