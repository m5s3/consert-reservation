package com.consertreservation.domain.seat.components;

import static com.consertreservation.domain.seat.exception.ReservationErrorCode.ALREADY_IN_SEAT;
import static com.consertreservation.domain.seat.exception.SeatErrorCode.ALREADY_RESERVED;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.consertreservation.domain.seat.exception.ReservationSeatException;
import com.consertreservation.domain.seat.exception.SeatException;
import com.consertreservation.domain.seat.model.Seat;
import com.consertreservation.domain.seat.model.SeatStatus;
import com.consertreservation.domain.seat.repository.ReservationSeatReadRepository;
import com.consertreservation.domain.seat.repository.ReservationSeatStoreRepository;
import com.consertreservation.domain.seat.repository.SeatReaderRepository;
import com.consertreservation.domain.usertoken.respositories.UserTokenReaderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReservationSeatComponentTest {
    
    @Mock
    ReservationSeatReadRepository reservationSeatReadRepository;

    @InjectMocks
    ReservationSeatComponent reservationSeatComponent;


    @Test
    @DisplayName("이미 예약된 좌석을 예약을 시도하면, 예외가 발생한다.")
    void reserve_already_seat_exception_test() {
        // Given
        Long seatId = 1L;
        Long userId = 1L;

        Mockito.when(reservationSeatReadRepository.isReservedSeat(seatId, userId))
                .thenReturn(Boolean.TRUE);

        // When & Then
        assertThatThrownBy(() -> reservationSeatComponent.reserveSeat(seatId, userId))
                .isInstanceOf(ReservationSeatException.class)
                .hasFieldOrPropertyWithValue("errorCode", ALREADY_IN_SEAT);
    }
}