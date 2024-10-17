package com.consertreservation.domain.concert.infra;

import com.consertreservation.domain.concert.model.ConcertSchedule;
import com.consertreservation.domain.concert.repository.ConcertScheduleStoreRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertScheduleJPARepository extends JpaRepository<ConcertSchedule, Long>,
        ConcertScheduleStoreRepository {
}
