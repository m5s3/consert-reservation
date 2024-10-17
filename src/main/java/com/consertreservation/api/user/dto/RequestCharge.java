package com.consertreservation.api.user.dto;

public record RequestCharge(
        Long userId,
        long amount
) {
}
