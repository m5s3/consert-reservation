package com.consertreservation.domain.seat;

import com.consertreservation.domain.base.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seat extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long id;

    private Long concert_schedule_id;
    private int seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="status", columnDefinition = "varchar(20)")
    private SeatStatus status;

    @Builder
    public Seat(Long id, Long concert_schedule_id, int seatNumber, SeatStatus status) {
        this.id = id;
        this.concert_schedule_id = concert_schedule_id;
        this.seatNumber = seatNumber;
        this.status = status;
    }
}
