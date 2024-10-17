package com.consertreservation.domain.concert.components;

import com.consertreservation.domain.concert.components.dto.ConcertDto;
import com.consertreservation.domain.concert.model.Concert;
import com.consertreservation.domain.concert.repository.ConcertStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class ConcertComponent {

    private final ConcertStoreRepository concertStoreRepository;

    public ConcertDto createConcert(String title) {
        Concert concert = Concert.builder()
                .title(title)
                .build();
        return ConcertDto.from(concertStoreRepository.save(concert));
    }
}
