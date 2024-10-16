package com.consertreservation.domain.concert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "concert_schedule_id")
    private Long id;

    private Long concertId;
    private LocalDateTime reservationStateDate;
    private LocalDateTime concertStartDate;
    private LocalDateTime concertEndDate;
    private int reservationSeat;
    private int remainOfReservationOfSeat;

    @Builder
    public ConcertSchedule(Long id, Long concertId, LocalDateTime reservationStateDate, LocalDateTime concertStartDate,
            LocalDateTime concertEndDate, int reservationSeat, int remainOfReservationOfSeat) {
        this.id = id;
        this.concertId = concertId;
        this.reservationStateDate = reservationStateDate;
        this.concertStartDate = concertStartDate;
        this.concertEndDate = concertEndDate;
        this.reservationSeat = reservationSeat;
        this.remainOfReservationOfSeat = remainOfReservationOfSeat;
    }
}
