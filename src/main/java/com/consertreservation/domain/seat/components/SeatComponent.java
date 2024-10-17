package com.consertreservation.domain.seat.components;


import com.consertreservation.domain.seat.components.dto.SeatDto;
import com.consertreservation.domain.seat.model.Seat;
import com.consertreservation.domain.seat.repository.SeatReaderRepository;
import com.consertreservation.domain.seat.repository.SeatStoreRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class SeatComponent {

    private final SeatStoreRepository seatStoreRepository;
    private final SeatReaderRepository seatReaderRepository;

    public SeatDto createSeat(Long concertScheduleId, int seatNumber) {
        Seat seat = Seat.builder()
                .concertScheduleId(concertScheduleId)
                .seatNumber(seatNumber)
                .build();
        return SeatDto.from(seatStoreRepository.save(seat));
    }

    public void validateFee(Long seatId, long amount) {
        Seat seat = seatReaderRepository.getSeat(seatId);
        seat.validateFee(amount);
    }

    @Transactional(readOnly = true)
    public List<SeatDto> getAvailableSeats(Long concertScheduleId) {
        List<Seat> seats = seatReaderRepository.getAvailableSeats(concertScheduleId);
        return seats.stream().map(SeatDto::from).toList();
    }
}
