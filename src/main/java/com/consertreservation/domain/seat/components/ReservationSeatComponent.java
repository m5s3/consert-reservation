package com.consertreservation.domain.seat.components;

import com.consertreservation.domain.seat.components.dto.ReservationSeatDto;
import com.consertreservation.domain.seat.model.ReservationSeat;
import com.consertreservation.domain.seat.model.ReservationSeatStatus;
import com.consertreservation.domain.seat.model.Seat;
import com.consertreservation.domain.seat.model.SeatStatus;
import com.consertreservation.domain.seat.repository.ReservationSeatStoreRepository;
import com.consertreservation.domain.seat.repository.SeatReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class ReservationSeatComponent {

    private final SeatReaderRepository seatReaderRepository;
    private final ReservationSeatStoreRepository reservationSeatStoreRepository;

    public ReservationSeatDto reserveSeat(Long seatId, Long userId) {
        Seat seat = seatReaderRepository.getSeat(seatId);
        seat.reserve();
        ReservationSeat reservationSeat = ReservationSeat.builder()
                .seatId(seatId)
                .userId(userId)
                .status(ReservationSeatStatus.ING)
                .build();
        return ReservationSeatDto.from(reservationSeatStoreRepository.save(reservationSeat));
    }
}
