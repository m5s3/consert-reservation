package com.consertreservation.domain.concert.repository;

import com.consertreservation.domain.concert.model.ConcertSchedule;

public interface ConcertScheduleRepository {

    ConcertSchedule save(ConcertSchedule concertSchedule);
}
