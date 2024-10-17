package com.consertreservation.domain.user.components.dto;

import com.consertreservation.domain.user.model.User;

public record UserChargeDto(
        Long userId,
        long amount
) {
    public static UserChargeDto from(User user) {
        return new UserChargeDto(user.getId(), user.getCharge());
    }
}
