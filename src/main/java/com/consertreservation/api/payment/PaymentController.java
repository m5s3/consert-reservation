package com.consertreservation.api.payment;

import com.consertreservation.api.payment.dto.RequestPayment;
import com.consertreservation.api.payment.dto.ResponsePayment;
import com.consertreservation.api.usecase.PaymentUseCase;
import com.consertreservation.domain.payment.components.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentUseCase paymentUseCase;

    @PostMapping
    public ResponseEntity<ResponsePayment> payment(@RequestBody RequestPayment request) {
        PaymentDto pay = paymentUseCase.pay(request.userId(), request.seatId(), request.amount());
        return ResponseEntity.ok()
                .body(ResponsePayment.of(pay.userId(), pay.seatId(), pay.amount(), pay.createdAt()));
    }
}
