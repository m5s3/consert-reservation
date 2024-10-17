package com.consertreservation.domain.payment.infra;

import com.consertreservation.domain.payment.model.Payment;
import com.consertreservation.domain.payment.repository.PaymentStoreRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJPARepository extends JpaRepository<Payment, Long>, PaymentStoreRepository {

}
