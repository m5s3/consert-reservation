package com.consertreservation.domain.seat.model;

import static com.consertreservation.domain.seat.exception.ReservationErrorCode.ALREADY_COMPLETED;

import com.consertreservation.domain.base.BaseTimeEntity;
import com.consertreservation.domain.seat.exception.ReservationSeatException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class ReservationSeat extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_seat_id")
    private Long id;

    private Long userId;
    private Long seatId;
    @Enumerated(EnumType.STRING)
    @Column(name="status", columnDefinition = "varchar(20)")
    private ReservationSeatStatus status;

    @Builder
    public ReservationSeat(Long id, Long userId, Long seatId, ReservationSeatStatus status) {
        this.id = id;
        this.userId = userId;
        this.seatId = seatId;
        this.status = status;
    }

    public void completeReservation() {
        if (status == ReservationSeatStatus.COMPLETED) {
            throw new ReservationSeatException(ALREADY_COMPLETED, "이미 완료된 결제입니다");
        }
        status = ReservationSeatStatus.COMPLETED;
    }

    public void cancelReservation() {
        status = ReservationSeatStatus.CANCELLED;
    }
}
