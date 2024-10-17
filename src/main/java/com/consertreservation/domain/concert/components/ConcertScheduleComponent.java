package com.consertreservation.domain.concert.components;

import com.consertreservation.domain.concert.components.dto.ConcertScheduleDto;
import com.consertreservation.domain.concert.infra.ConcertScheduleScheduleCustomRepository;
import com.consertreservation.domain.concert.model.ConcertSchedule;
import com.consertreservation.domain.concert.repository.ConcertScheduleStoreRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class ConcertScheduleComponent {

    private final ConcertScheduleScheduleCustomRepository concertScheduleCustomRepository;
    private final ConcertScheduleStoreRepository concertScheduleStoreRepository;

    public void validateAvailableReservation(long concertId, LocalDateTime date) {
        ConcertSchedule concertSchedule = concertScheduleCustomRepository.getConcertSchedule(concertId);
        ConcertScheduleValidator.validate(concertSchedule);
        concertSchedule.validateAvailable(date);
    }

    public ConcertScheduleDto showConcertSchedule(long concertId) {
        return ConcertScheduleDto.from(concertScheduleCustomRepository.getConcertSchedule(concertId));
    }

    public ConcertScheduleDto createConcertSchedule(
            Long concertId,
            LocalDateTime reservationStateDate,
            LocalDateTime concertStartDate,
            LocalDateTime concertEndDate,
            int reservationSeat,
            int remainOfReservationOfSeat
    ) {
        ConcertSchedule concertSchedule = ConcertSchedule.builder()
                .concertId(concertId)
                .reservationStateDate(reservationStateDate)
                .concertStartDate(concertStartDate)
                .concertEndDate(concertEndDate)
                .reservationSeat(reservationSeat)
                .remainOfReservationOfSeat(remainOfReservationOfSeat)
                .build();
        return ConcertScheduleDto.from(concertScheduleStoreRepository.save(concertSchedule));
    }
}
