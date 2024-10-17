package com.consertreservation.api.usecase;

import com.consertreservation.domain.concert.components.ConcertComponent;
import com.consertreservation.domain.concert.components.ConcertScheduleComponent;
import com.consertreservation.domain.concert.components.dto.ConcertDto;
import com.consertreservation.domain.concert.components.dto.ConcertScheduleDto;
import com.consertreservation.domain.concert.components.dto.ConcertWithScheduleDto;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConcertUseCase {

    private final ConcertComponent concertComponent;
    private final ConcertScheduleComponent concertScheduleComponent;

    public ConcertWithScheduleDto createConcert(
            String title,
            LocalDateTime reservationStateDate,
            LocalDateTime concertStartDate,
            LocalDateTime concertEndDate,
            int reservationSeat,
            int remainOfReservationOfSeat
    ) {
        ConcertDto concert = concertComponent.createConcert(title);
        ConcertScheduleDto concertSchedule = concertScheduleComponent.createConcertSchedule(concert.id(),
                reservationStateDate,
                concertStartDate,
                concertEndDate,
                reservationSeat,
                remainOfReservationOfSeat);
        return ConcertWithScheduleDto.from(concert, concertSchedule);
    }
}
