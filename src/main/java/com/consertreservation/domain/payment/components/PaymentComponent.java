package com.consertreservation.domain.payment.components;

import com.consertreservation.domain.payment.components.dto.PaymentDto;
import com.consertreservation.domain.payment.model.Payment;
import com.consertreservation.domain.payment.repository.PaymentStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class PaymentComponent {

    private final PaymentStoreRepository paymentStoreRepository;

    public PaymentDto pay(long userId, long seatId, long amount) {
        Payment payment = Payment.builder()
                .userId(userId)
                .seatId(seatId)
                .amount(amount)
                .build();
        return PaymentDto.from(paymentStoreRepository.save(payment));
    }
}
