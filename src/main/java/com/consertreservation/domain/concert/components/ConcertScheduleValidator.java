package com.consertreservation.domain.concert.components;

import static com.consertreservation.domain.concert.exception.ConcertScheduleErrorCode.NOT_FOUND;

import com.consertreservation.domain.concert.exception.ConcertScheduleException;
import com.consertreservation.domain.concert.model.ConcertSchedule;
import java.util.Objects;

public class ConcertScheduleValidator {

    public static void validate(ConcertSchedule concertSchedule) {
        if (Objects.isNull(concertSchedule)) {
            throw new ConcertScheduleException(NOT_FOUND, "콘서트 스케줄을 찾을 수 없습니다");
        }
    }
}
