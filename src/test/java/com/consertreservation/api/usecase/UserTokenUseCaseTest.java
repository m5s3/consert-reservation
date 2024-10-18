package com.consertreservation.api.usecase;

import static org.assertj.core.api.Assertions.*;

import com.consertreservation.domain.usertoken.components.dto.UserTokenDto;
import com.consertreservation.domain.usertoken.model.UserToken;
import com.consertreservation.domain.usertoken.respositories.UserTokenReaderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTokenUseCaseTest {

    @Autowired
    UserTokenUseCase userTokenUseCase;

    @Autowired
    UserTokenReaderRepository userTokenReaderRepository;

    @Test
    @DisplayName("유저 토큰 발행")
    void get_userToken() {
        // When
        UserTokenDto userToken = userTokenUseCase.getUserToken(1L);

        // Then
        UserToken findUserToken = userTokenReaderRepository.getUserToken(userToken.userId()).get();
        assertThat(findUserToken).isNotNull();
    }
}