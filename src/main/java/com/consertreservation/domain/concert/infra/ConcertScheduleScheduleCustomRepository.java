package com.consertreservation.domain.concert.infra;

import static com.consertreservation.domain.concert.model.QConcertSchedule.concertSchedule;

import com.consertreservation.domain.concert.model.ConcertSchedule;
import com.consertreservation.domain.concert.repository.ConcertScheduleReaderRepository;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ConcertScheduleScheduleCustomRepository implements ConcertScheduleReaderRepository {

    private final JPQLQueryFactory queryFactory;

    @Override
    public ConcertSchedule getConcertSchedule(Long concertId) {
        return queryFactory.selectFrom(concertSchedule)
                .where(concertSchedule.concertId.eq(concertId))
                .fetchOne();
    }
}
