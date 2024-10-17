package com.consertreservation.api.usecase;

import com.consertreservation.domain.seat.components.ReservationSeatComponent;
import com.consertreservation.domain.seat.components.SeatComponent;
import com.consertreservation.domain.seat.components.dto.ReservationSeatDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ReserveSeatCronUserCase {

    private final ReservationSeatComponent reservationSeatComponent;
    private final SeatComponent seatComponent;
    @Value("${schedule.reserveSeat.restore.active}")
    private boolean restoreReservedSeatFlag;

    @Scheduled(cron = "${schedule.reserveSeat.restore.cron}")
    public void restoreReservedSeat() {
        if (!restoreReservedSeatFlag) {
            return;
        }
        log.info("======10분 이내에 예악이 완료되지 않은 죄석 예약 이용 가능하도록 수정 작업 시작======");
        List<ReservationSeatDto> reservationSeats = reservationSeatComponent.getExpiredReservationSeats();
        reservationSeatComponent.changeReservationSeatsStatusToCancel();
        seatComponent.restoreReservedSeat(reservationSeats.stream().map(ReservationSeatDto::seatId).toList());
        log.info("======10분 이내에 예악이 완료되지 않은 죄석 예약 이용 가능하도록 수정 작업 종료======");
    }
}
