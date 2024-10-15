package com.consertreservation.domain.usertoken.model;

import static com.consertreservation.domain.usertoken.exception.UserTokenErrorCode.INVALID_WAITING_ORDER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.consertreservation.domain.usertoken.exception.UserTokenErrorCode;
import com.consertreservation.domain.usertoken.exception.UserTokenException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTokenTest {

    @Test
    @DisplayName("대기순서가 음수일 경우 예외가 발생한다.")
    void userToken_updateOrder_test() {
        // Given
        UserToken userToken = UserToken.builder()
                .build();

        // When & Then
        assertThatThrownBy(() -> userToken.updateWaitingOrder(-1))
                .isInstanceOf(UserTokenException.class)
                .hasFieldOrPropertyWithValue("errorCode", INVALID_WAITING_ORDER);
    }
}