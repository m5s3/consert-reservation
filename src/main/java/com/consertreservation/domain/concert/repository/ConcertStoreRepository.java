package com.consertreservation.domain.concert.repository;

import com.consertreservation.domain.concert.model.Concert;
import com.consertreservation.domain.concert.model.ConcertSchedule;

public interface ConcertStoreRepository {

    Concert save(Concert concert);
}
