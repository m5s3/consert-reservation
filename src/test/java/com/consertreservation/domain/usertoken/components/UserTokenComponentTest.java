package com.consertreservation.domain.usertoken.components;

import static org.junit.jupiter.api.Assertions.*;

import com.consertreservation.domain.usertoken.components.dto.CreateUserTokenDto;
import com.consertreservation.domain.usertoken.model.TokenStatus;
import com.consertreservation.domain.usertoken.model.UserToken;
import com.consertreservation.domain.usertoken.model.UserToken.UserTokenBuilder;
import com.consertreservation.domain.usertoken.respositories.UserTokenStoreRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserTokenComponentTest {

    @Mock
    UserTokenStoreRepository userTokenStoreRepository;
    @InjectMocks
    UserTokenComponent userTokenComponent;

    @Test
    @DisplayName("유저 토큰 생성")
    void create_userToken_test() {
        // Given
        long userId = 1L;
        UserToken userToken = UserToken.builder()
                .userid(userId)
                .status(TokenStatus.WAIT)
                .build();
        Mockito.when(userTokenStoreRepository.save(Mockito.any(UserToken.class))).thenReturn(userToken);
        // When & Then
        CreateUserTokenDto newUserToken = userTokenComponent.createToken(userId);
        Assertions.assertThat(newUserToken.userId()).isEqualTo(userId);
    }
}