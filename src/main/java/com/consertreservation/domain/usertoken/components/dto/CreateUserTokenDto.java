package com.consertreservation.domain.usertoken.components.dto;

import com.consertreservation.domain.usertoken.model.TokenStatus;
import com.consertreservation.domain.usertoken.model.UserToken;
import java.util.UUID;

public record CreateUserTokenDto(
        UUID id,
        long userId,
        int waitingOrder,
        TokenStatus status
) {

    public static CreateUserTokenDto from(UserToken userToken) {
        return new CreateUserTokenDto(userToken.getId(), userToken.getUserId(), userToken.getWaitingOrder(), userToken.getStatus());
    }
}
