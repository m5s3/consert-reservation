package com.consertreservation.domain.concert.model;

import static com.consertreservation.domain.concert.exception.ConcertScheduleErrorCode.FULL_RESERVATION_SEAT;
import static com.consertreservation.domain.concert.exception.ConcertScheduleErrorCode.INVALID_RESERVATION_DATE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.consertreservation.domain.concert.exception.ConcertScheduleException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConcertScheduleTest {

    @Test
    @DisplayName("예약 시작일보다 예약을 하면 예외가 발생한다")
    void validate_available_before_date_test() {
        // Given
        ConcertSchedule concertSchedule = ConcertSchedule.builder()
                .reservationStartDate(LocalDateTime.now().plusDays(1))
                .concertStartDate(LocalDateTime.now().plusDays(2))
                .build();

        // When & Then
        assertThatThrownBy(() -> concertSchedule.validateAvailable(LocalDateTime.now()))
                .isInstanceOf(ConcertScheduleException.class)
                .hasFieldOrPropertyWithValue("errorCode", INVALID_RESERVATION_DATE);
    }

    @Test
    @DisplayName("예약이 끝난 콘서트를 예약을 하면 예약을 하면 예외가 발생한다")
    void validate_available_after_date_test() {
        // Given
        ConcertSchedule concertSchedule = ConcertSchedule.builder()
                .reservationStartDate(LocalDateTime.now().minusDays(2))
                .concertStartDate(LocalDateTime.now().minusDays(1))
                .build();

        // When & Then
        assertThatThrownBy(() -> concertSchedule.validateAvailable(LocalDateTime.now()))
                .isInstanceOf(ConcertScheduleException.class)
                .hasFieldOrPropertyWithValue("errorCode", INVALID_RESERVATION_DATE);
    }

    @Test
    @DisplayName("잔여 좌석이 0일때 감소를 하려고 하면 예외가 발생한다")
    void decrease_remain_of_seat_test() {
        // Given
        ConcertSchedule concertSchedule = ConcertSchedule.builder()
                .remainOfReservationSeat(0)
                .build();

        // When & Then
        assertThatThrownBy(concertSchedule::decreaseRemainOfSeat)
                .isInstanceOf(ConcertScheduleException.class)
                .hasFieldOrPropertyWithValue("errorCode", FULL_RESERVATION_SEAT);
    }
}
