package com.consertreservation.domain.seat.components;

import com.consertreservation.domain.seat.components.dto.SeatDto;
import com.consertreservation.domain.seat.model.Seat;
import com.consertreservation.domain.seat.repository.SeatStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class SeatComponent {

    private final SeatStoreRepository seatStoreRepository;

    public SeatDto createSeat(Long concertScheduleId, int seatNumber) {
        Seat seat = Seat.builder()
                .concertScheduleId(concertScheduleId)
                .seatNumber(seatNumber)
                .build();
        return SeatDto.from(seatStoreRepository.save(seat));
    }
}
