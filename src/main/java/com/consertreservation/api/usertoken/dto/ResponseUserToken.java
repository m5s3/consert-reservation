package com.consertreservation.api.usertoken.dto;

import com.consertreservation.domain.usertoken.components.dto.UserTokenDto;
import java.util.UUID;

public record ResponseUserToken(
        UUID id,
        long userId,
        String status,
        int waitingOrder
) {

    public static ResponseUserToken fromUserTokenDto(UserTokenDto userTokenDto) {
        return new ResponseUserToken(userTokenDto.id(), userTokenDto.userId(), userTokenDto.tokenStatus().name(),
                userTokenDto.waitingOrder());
    }
}
