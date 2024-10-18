package com.consertreservation.api.usecase;

import com.consertreservation.domain.usertoken.components.UserTokenComponent;
import com.consertreservation.domain.usertoken.components.dto.UserTokenDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserTokenUseCase {

    private final UserTokenComponent userTokenComponent;

    public UserTokenDto getUserToken(Long userId) {
        UserTokenDto userTokenDto = userTokenComponent.showUserToken(userId)
                .orElseGet(() -> userTokenComponent.createToken(userId));

        if (userTokenComponent.isExpired(userTokenDto.userId())) {
            return userTokenComponent.createToken(userId);
        }

        return userTokenDto;
    }
}
