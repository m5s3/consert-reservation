package com.consertreservation.api.payment.dto;

import com.consertreservation.domain.payment.model.Payment;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

/**
 * jsonformat
 */
public record ResponsePayment(
        Long userId,
        Long seatId,
        Long amount,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        LocalDateTime createdAt
) {
    public static ResponsePayment of(long userId, long seatId, long amount, LocalDateTime createdAt) {
        return new ResponsePayment(userId, seatId, amount, createdAt);
    }
}
