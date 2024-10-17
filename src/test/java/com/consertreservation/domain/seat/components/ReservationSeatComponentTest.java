package com.consertreservation.domain.seat.components;

import static org.junit.jupiter.api.Assertions.*;

import com.consertreservation.domain.usertoken.respositories.UserTokenReaderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class ReservationSeatTest {

    @InjectMocks
    ReservationSeat reservationSeat;

    @Mock
    UserTokenReaderRepository userTokenReaderRepository;

    @Mock
    ReservationSeatStoreRepository reservationSeatStoreRepository;

    @Mock
    SeatReaderRepository seatReaderRepository;

    @Test
    @DisplayName("좌석 에약")
    void reserve_seat_test() {
        // Given
        
        seatReaderRepository.getSeat(1L);

        // When

        // Then

    }
}