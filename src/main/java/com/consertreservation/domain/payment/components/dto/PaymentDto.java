package com.consertreservation.domain.payment.components.dto;

import com.consertreservation.domain.payment.model.Payment;
import java.time.LocalDateTime;

/**
 * private Long id;
 *     private Long userId;
 *     private Long reservationSeatId;
 *     private Long amount;
 */
public record PaymentDto(
        Long id,
        Long userId,
        Long seatId,
        Long amount,
        LocalDateTime createdAt
) {

    public static PaymentDto from(Payment payment) {
        return new PaymentDto(payment.getId(), payment.getUserId(), payment.getSeatId(), payment.getAmount(),
                payment.getCreatedAt());
    }
}
