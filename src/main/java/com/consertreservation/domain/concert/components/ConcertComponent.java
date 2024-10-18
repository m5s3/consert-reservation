package com.consertreservation.domain.concert.components;

import com.consertreservation.domain.concert.components.dto.ConcertDto;
import com.consertreservation.domain.concert.components.dto.ConcertWithScheduleDto;
import com.consertreservation.domain.concert.model.Concert;
import com.consertreservation.domain.concert.model.ConcertSchedule;
import com.consertreservation.domain.concert.repository.ConcertReaderRepository;
import com.consertreservation.domain.concert.repository.ConcertScheduleReaderRepository;
import com.consertreservation.domain.concert.repository.ConcertStoreRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class ConcertComponent {

    private final ConcertStoreRepository concertStoreRepository;
    private final ConcertReaderRepository concertReaderRepository;
    private final ConcertScheduleReaderRepository concertScheduleReaderRepository;

    public ConcertDto createConcert(String title) {
        Concert concert = Concert.builder()
                .title(title)
                .build();
        return ConcertDto.fromEntity(concertStoreRepository.save(concert));
    }

    public List<ConcertWithScheduleDto> getConcerts(LocalDateTime dateTime) {
        List<ConcertSchedule> concertSchedules = concertScheduleReaderRepository.getConcertSchedules(dateTime);
        List<Long> concertIds = concertSchedules.stream().map(ConcertSchedule::getConcertId).toList();
        List<Concert> concerts = concertReaderRepository.getConcerts(concertIds);
        Map<Long, ConcertSchedule> concertScheduleMap = concertSchedules.stream().collect(
                Collectors.toMap(concertSchedule -> concertSchedule.getConcertId(),
                        concertSchedule -> concertSchedule));

        return concerts.stream().map(concert -> ConcertWithScheduleDto.of(concert, concertScheduleMap.get(concert.getId())))
                .toList();
    }
}
