package com.consertreservation.domain.concert.repository;

import com.consertreservation.domain.concert.model.Concert;
import java.time.LocalDateTime;
import java.util.List;

public interface ConcertReaderRepository {

    List<Concert> getConcerts(List<Long> concertIds);
}
