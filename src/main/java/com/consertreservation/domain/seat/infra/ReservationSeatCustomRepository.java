package com.consertreservation.domain.seat.infra;

import static com.consertreservation.domain.seat.model.QReservationSeat.reservationSeat;

import com.consertreservation.domain.seat.model.ReservationSeatStatus;
import com.consertreservation.domain.seat.repository.ReservationSeatReadRepository;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ReservationSeatCustomRepository implements ReservationSeatReadRepository {

    private final JPQLQueryFactory queryFactory;

    @Override
    public boolean isReservedSeat(Long seatId, Long userId) {
        return queryFactory.from(reservationSeat)
                .where(reservationSeat.userId.eq(userId))
                .where(reservationSeat.seatId.eq(userId))
                .where(reservationSeat.status.ne(ReservationSeatStatus.CANCELLED))
                .fetchFirst() != null;
    }
}
