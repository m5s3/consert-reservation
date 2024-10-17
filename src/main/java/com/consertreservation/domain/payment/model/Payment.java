package com.consertreservation.domain.payment.model;

import com.consertreservation.domain.base.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;
    private Long userId;
    private Long seatId;
    private Long amount;

    @Builder
    public Payment(Long id, Long userId, Long seatId, Long amount) {
        this.id = id;
        this.userId = userId;
        this.seatId = seatId;
        this.amount = amount;
    }
}
