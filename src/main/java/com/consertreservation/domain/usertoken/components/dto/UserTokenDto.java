package com.consertreservation.domain.usertoken.components.dto;

import com.consertreservation.domain.usertoken.model.TokenStatus;
import com.consertreservation.domain.usertoken.model.UserToken;
import java.util.UUID;

public record UserTokenDto(
        UUID id,
        long userId,
        TokenStatus tokenStatus,
        int waitingOrder
) {

    public static UserTokenDto from(UserToken userToken) {
        return new UserTokenDto(userToken.getId(), userToken.getUserId(), userToken.getStatus(), userToken.getWaitingOrder());
    }

    public static UserTokenDto from(CreateUserTokenDto createUserTokenDto) {
        return new UserTokenDto(createUserTokenDto.id(), createUserTokenDto.userId(), createUserTokenDto.status(),
                createUserTokenDto.waitingOrder());
    }
}
