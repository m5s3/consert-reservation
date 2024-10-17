package com.consertreservation.domain.concert.components;

import com.consertreservation.domain.concert.components.dto.ConcertScheduleDto;
import com.consertreservation.domain.concert.infra.ConcertScheduleCustomRepository;
import com.consertreservation.domain.concert.model.ConcertSchedule;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class ConcertScheduleComponent {

    private final ConcertScheduleCustomRepository concertScheduleCustomRepository;

    public boolean isAvailableReservation(long concertId, LocalDateTime date) {
        ConcertSchedule concertSchedule = concertScheduleCustomRepository.getConcertSchedule(concertId);
        ConcertScheduleValidator.validate(concertSchedule);
        return concertSchedule.isAvailableSchedule(date);
    }

    public ConcertScheduleDto showConcertSchedule(long concertId) {
        return ConcertScheduleDto.from(concertScheduleCustomRepository.getConcertSchedule(concertId));
    }
}
