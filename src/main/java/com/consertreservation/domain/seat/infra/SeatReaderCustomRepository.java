package com.consertreservation.domain.seat.infra;

import static com.consertreservation.domain.seat.model.QSeat.seat;

import com.consertreservation.domain.seat.model.Seat;
import com.consertreservation.domain.seat.repository.SeatReaderRepository;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SeatReaderCustomRepository implements SeatReaderRepository {

    private final JPQLQueryFactory queryFactory;

    @Override
    public Seat getSeat(Long id) {
        return queryFactory.selectFrom(seat)
                .where(seat.id.eq(id))
                .fetchFirst();
    }
}
