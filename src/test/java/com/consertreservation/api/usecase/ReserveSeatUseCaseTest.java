package com.consertreservation.api.usecase;

import static org.junit.jupiter.api.Assertions.*;

import com.consertreservation.domain.usertoken.model.TokenStatus;
import com.consertreservation.domain.usertoken.model.UserToken;
import com.consertreservation.domain.usertoken.respositories.UserTokenStoreRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReserveSeatUseCaseTest {

    @Autowired
    ReserveSeatUseCase reserveSeatUseCase;

    @Autowired
    UserTokenStoreRepository userTokenStoreRepository;
    
    @Test
    @DisplayName("권한이 없는 유저가 예약을 하면 예외가 발생한다")
    void reserve_seat_unauthorized_test() {
        // Given
        long userId = 1L;
        long concertId = 1L;
        long seatId = 1L;
        
        // 유저토큰 생성
        UserToken newUserToken = UserToken.builder()
                .id(UUID.randomUUID())
                .userid(userId)
                .status(TokenStatus.WAIT)
                .build();
        userTokenStoreRepository.save(newUserToken);
        
        // When
        reserveSeatUseCase.reserveSeat(seatId, userId, concertId, LocalDateTime.now());
    
        // Then
        
    }
}