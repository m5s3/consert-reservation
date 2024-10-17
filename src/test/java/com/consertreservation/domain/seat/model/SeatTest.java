package com.consertreservation.domain.seat.model;

import static com.consertreservation.domain.seat.exception.SeatErrorCode.ALREADY_RESERVED;
import static com.consertreservation.domain.seat.exception.SeatErrorCode.INVALID_LESS_FEE;
import static com.consertreservation.domain.seat.exception.SeatErrorCode.INVALID_MORE_FEE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import com.consertreservation.domain.seat.exception.SeatException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeatTest {

    @Test
    @DisplayName("예약돤 좌석을 예약을 하면 예외가 발생한다")
    void reserve_test() {
        // Given
        Seat seat = Seat.builder()
                .status(SeatStatus.RESERVED)
                .build();

        // When & Then
        assertThatThrownBy(seat::reserve)
                .isInstanceOf(SeatException.class)
                .hasFieldOrPropertyWithValue("errorCode", ALREADY_RESERVED);
    }

    @Test
    @DisplayName("좌석 금액보다 더 큰 금액을 지불하면 예외가 발생한다")
    void validate_fee_more_test() {
        // Given
        Seat seat = Seat.builder()
                .fee(1000)
                .build();

        // When & Then
        assertThatThrownBy(() -> seat.validateFee(1001))
                .isInstanceOf(SeatException.class)
                .hasFieldOrPropertyWithValue("errorCode", INVALID_MORE_FEE);
    }

    @Test
    @DisplayName("좌석 금액보다 더 작은 금액을 지분하면 예외가 발생한다")
    void validate_fee_less_test() {
        // Given
        Seat seat = Seat.builder()
                .fee(1000)
                .build();
        // When & Then
        assertThatThrownBy(() -> seat.validateFee(999))
                .isInstanceOf(SeatException.class)
                .hasFieldOrPropertyWithValue("errorCode", INVALID_LESS_FEE);
    }
}