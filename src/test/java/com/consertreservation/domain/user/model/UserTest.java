package com.consertreservation.domain.user.model;

import static com.consertreservation.domain.user.exception.UserErrorCode.INVALID_CHARGE;
import static com.consertreservation.domain.user.exception.UserErrorCode.NOT_ENOUGH_CHARGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.consertreservation.domain.user.exception.UserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("사용 금액이 남은 충전 금액보다 크면 예외가 발생한다")
    void minus_charge_test() {
        // Given
        User user = User.builder()
                .charge(1000)
                .build();

        // When &Then
        assertThatThrownBy(() -> user.minusCharge(10000))
                .isInstanceOf(UserException.class)
                .hasFieldOrPropertyWithValue("errorCode", NOT_ENOUGH_CHARGE);
    }

    @Test
    @DisplayName("충전금액이 음수이면 예외가 발생한다")
    void add_charge_test() {
        // Given
        User user = User.builder()
                .charge(1000)
                .build();
        // When &Then
        assertThatThrownBy(() -> user.addCharge(-10000))
                .isInstanceOf(UserException.class)
                .hasFieldOrPropertyWithValue("errorCode", INVALID_CHARGE);

    }
}