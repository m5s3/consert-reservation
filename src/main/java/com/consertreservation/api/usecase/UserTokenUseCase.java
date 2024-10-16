package com.consertreservation.api.usecase;

import com.consertreservation.domain.usertoken.components.UserTokenComponent;
import com.consertreservation.domain.usertoken.components.dto.UserTokenDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserTokenUseCase {

    private final UserTokenComponent userTokenComponent;

    public UserTokenDto getUserToken(Long userId) {
        return userTokenComponent.showUserToken(userId).orElseGet(() -> userTokenComponent.createToken(userId));
    }
}
