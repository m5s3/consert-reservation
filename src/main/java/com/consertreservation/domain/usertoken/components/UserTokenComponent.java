package com.consertreservation.domain.usertoken.components;

import com.consertreservation.domain.usertoken.components.dto.UserTokenDto;
import com.consertreservation.domain.usertoken.model.TokenStatus;
import com.consertreservation.domain.usertoken.model.UserToken;
import com.consertreservation.domain.usertoken.respositories.UserTokenReaderRepository;
import com.consertreservation.domain.usertoken.respositories.UserTokenStoreRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
@Transactional
public class UserTokenComponent {

    private final UserTokenStoreRepository userTokenStoreRepository;
    private final UserTokenReaderRepository userTokenReaderRepository;

    public UserTokenDto createToken(long userId) {
        UserToken userToken = UserToken.builder()
                .userid(userId)
                .status(TokenStatus.WAIT)
                .build();
        UserToken newUserToken = userTokenStoreRepository.save(userToken);
        newUserToken.updateWaitingOrder(calculateWaitingOrder());
        return UserTokenDto.from(newUserToken);
    }

    @Transactional(readOnly = true)
    public Optional<UserTokenDto> showUserToken(long userId) {
        Optional<UserToken> userToken = userTokenReaderRepository.getUserToken(userId);
        return userToken.map(UserTokenDto::from);
    }

    private int calculateWaitingOrder() {
        int countOfWaitingUserToken = userTokenReaderRepository.getWaitOfUserTokenCount().intValue();
        return ++countOfWaitingUserToken;
    }
}
