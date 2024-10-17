package com.consertreservation.api.usecase;

import com.consertreservation.domain.user.components.UserComponent;
import com.consertreservation.domain.user.components.dto.UserChargeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserUseCase {

    private final UserComponent userComponent;

    @Transactional(readOnly = true)
    public UserChargeDto getCharge(Long userId) {
        return userComponent.getCharge(userId);
    }

    public UserChargeDto charge(Long userId, long amount) {
        return userComponent.charge(userId, amount);
    }
}
