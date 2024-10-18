package com.consertreservation.api.usecase;

import com.consertreservation.domain.seat.components.SeatComponent;
import com.consertreservation.domain.seat.components.dto.SeatDto;
import com.consertreservation.domain.usertoken.components.UserTokenComponent;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SeatUserCase {

    private final SeatComponent seatComponent;
    private final UserTokenComponent userTokenComponent;

    @Transactional(readOnly = true)
    public List<SeatDto> getAvailableSeats(Long userId, Long concertScheduleId) {
        userTokenComponent.validateAuthorization(userId);
        return seatComponent.getAvailableSeats(concertScheduleId);
    }
}
