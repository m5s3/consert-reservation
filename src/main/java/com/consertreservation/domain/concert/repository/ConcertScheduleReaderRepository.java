package com.consertreservation.domain.concert.repository;

import com.consertreservation.domain.concert.model.ConcertSchedule;

public interface ConcertScheduleReaderRepository {

    ConcertSchedule getConcertSchedule(Long concertId);
}
