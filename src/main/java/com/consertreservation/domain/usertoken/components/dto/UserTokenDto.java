package com.consertreservation.domain.usertoken.components.dto;

import com.consertreservation.domain.usertoken.model.TokenStatus;
import com.consertreservation.domain.usertoken.model.UserToken;
import java.util.UUID;

public record UserTokenDto(
        UUID id,
        long userId,
        TokenStatus tokenStatus
) {

    public static UserTokenDto from(UserToken userToken) {
        return new UserTokenDto(userToken.getId(), userToken.getUserId(), userToken.getStatus());
    }
}
