package com.consertreservation.domain.user.model;

import static com.consertreservation.domain.user.exception.UserErrorCode.NOT_ENOUGH_CHARGE;

import com.consertreservation.domain.base.BaseTimeEntity;
import com.consertreservation.domain.user.exception.UserErrorCode;
import com.consertreservation.domain.user.exception.UserException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private long charge;
    private String name;

    public void minusCharge(long amount) {
        if (charge < amount) {
            throw new UserException(NOT_ENOUGH_CHARGE, "충전 금액이 충분하지 않습니다");
        }
        charge -= amount;
    }
}


