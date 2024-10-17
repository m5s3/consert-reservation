package com.consertreservation.api.user.dto;

public record ResponseCharge(
        Long userId,
        long amount
) {
    public static ResponseCharge of(Long userId, long amount) {
        return new ResponseCharge(userId, amount);
    }
}
