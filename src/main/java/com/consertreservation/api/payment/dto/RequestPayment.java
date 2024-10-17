package com.consertreservation.api.payment.dto;

public record RequestPayment(
        Long userId,
        Long seatId,
        Long amount
) {

}
