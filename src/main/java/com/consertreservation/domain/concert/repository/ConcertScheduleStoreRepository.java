package com.consertreservation.domain.concert.repository;

import com.consertreservation.domain.concert.model.ConcertSchedule;

public interface ConcertScheduleStoreRepository {

    ConcertSchedule save(ConcertSchedule concertSchedule);
}
