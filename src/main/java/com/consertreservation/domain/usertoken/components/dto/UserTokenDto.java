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

    public static UserToken toEntity(UserTokenDto dto) {
        return UserToken.builder()
                .id(dto.id)
                .userid(dto.userId)
                .status(dto.tokenStatus)
                .build();
    }
}
