package com.consertreservation.api.usecase;

import com.consertreservation.domain.seat.components.SeatComponent;
import com.consertreservation.domain.seat.components.dto.SeatDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SeatUserCase {

    private final SeatComponent seatComponent;

    @Transactional(readOnly = true)
    public List<SeatDto> getAvailableSeats(Long concertScheduleId) {
        return seatComponent.getAvailableSeats(concertScheduleId);
    }
}
