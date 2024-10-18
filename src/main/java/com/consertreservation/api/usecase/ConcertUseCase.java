package com.consertreservation.api.usecase;

import com.consertreservation.domain.concert.components.ConcertComponent;
import com.consertreservation.domain.concert.components.ConcertScheduleComponent;
import com.consertreservation.domain.concert.components.dto.ConcertDto;
import com.consertreservation.domain.concert.components.dto.ConcertScheduleDto;
import com.consertreservation.domain.concert.components.dto.ConcertWithScheduleDto;
import com.consertreservation.domain.seat.components.SeatComponent;
import com.consertreservation.domain.usertoken.components.UserTokenComponent;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConcertUseCase {

    private static int COUNT_OF_SEAT = 50;

    private final ConcertComponent concertComponent;
    private final ConcertScheduleComponent concertScheduleComponent;
    private final SeatComponent seatComponent;
    private final UserTokenComponent userTokenComponent;

    public ConcertWithScheduleDto createConcert(
            String title,
            LocalDateTime reservationStateDate,
            LocalDateTime concertStartDate,
            LocalDateTime concertEndDate,
            int reservationSeat
    ) {
        ConcertDto concert = concertComponent.createConcert(title);
        ConcertScheduleDto concertSchedule = concertScheduleComponent.createConcertSchedule(concert.id(),
                reservationStateDate,
                concertStartDate,
                concertEndDate,
                reservationSeat);
        generateSeats(concertSchedule);
        return ConcertWithScheduleDto.from(concert, concertSchedule);
    }

    private void generateSeats(ConcertScheduleDto concertSchedule) {
        for(int i = 1; i <= COUNT_OF_SEAT; i ++) {
            seatComponent.createSeat(concertSchedule.id(), i);
        }
    }

    public List<ConcertWithScheduleDto> searchConcertByDate(Long userId, LocalDateTime dateTime) {
        userTokenComponent.validateAuthorization(userId);
        return concertComponent.getConcerts(dateTime);
    }
}
