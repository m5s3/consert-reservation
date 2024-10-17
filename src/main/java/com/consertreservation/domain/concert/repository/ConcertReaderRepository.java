package com.consertreservation.domain.concert.repository;

import com.consertreservation.domain.concert.model.ConcertSchedule;

public interface ConcertReaderRepository {

    ConcertSchedule getConcertSchedule(Long concertId);
}
