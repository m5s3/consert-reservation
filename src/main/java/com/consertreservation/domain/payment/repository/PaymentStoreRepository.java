package com.consertreservation.domain.payment.repository;

import com.consertreservation.domain.payment.model.Payment;

public interface PaymentStoreRepository {

    Payment save(Payment payment);
}
