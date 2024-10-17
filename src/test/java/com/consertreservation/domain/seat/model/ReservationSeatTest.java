package com.consertreservation.domain.seat.model;

import static com.consertreservation.domain.seat.exception.ReservationErrorCode.ALREADY_COMPLETED;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.consertreservation.domain.seat.exception.ReservationSeatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservationSeatTest {

    @Test
    @DisplayName("이미 완료된 예약 좌석을 완료 상태로 수정하면 예외가 발생한다")
    void complete_rervation_test() {
        // Given

        ReservationSeat reservationSeat = ReservationSeat.builder()
                .status(ReservationSeatStatus.COMPLETED)
                .build();

        // When & Then
        assertThatThrownBy(reservationSeat::completeReservation)
                .isInstanceOf(ReservationSeatException.class)
                .hasFieldOrPropertyWithValue("errorCode", ALREADY_COMPLETED);
    }

}