package com.consertreservation.domain.usertoken.components;

import com.consertreservation.domain.usertoken.components.dto.CreateUserTokenDto;
import com.consertreservation.domain.usertoken.components.dto.UserTokenDto;
import com.consertreservation.domain.usertoken.model.TokenStatus;
import com.consertreservation.domain.usertoken.model.UserToken;
import com.consertreservation.domain.usertoken.respositories.UserTokenReaderRepository;
import com.consertreservation.domain.usertoken.respositories.UserTokenStoreRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class UserTokenComponent {

    private final UserTokenStoreRepository storeRepository;
    private final UserTokenReaderRepository userTokenReaderRepository;

    public CreateUserTokenDto createToken(long userId) {
        UserToken userToken = UserToken.builder()
                .userid(userId)
                .status(TokenStatus.WAIT)
                .build();
        UserToken newUserToken = storeRepository.save(userToken);
        newUserToken.updateWaitingOrder(calculateWaitingOrder());
        return CreateUserTokenDto.from(newUserToken);
    }

    @Transactional(readOnly = true)
    public UserTokenDto showUserToken(long userId) {
        UserToken userToken = userTokenReaderRepository.getUserToken(userId);
        if (Objects.isNull(userToken)) {
            CreateUserTokenDto token = createToken(userId);
            return UserTokenDto.from(token);
        }
        return UserTokenDto.from(userToken);
    }

    private int calculateWaitingOrder() {
        int countOfWaitingUserToken = userTokenReaderRepository.getWaitOfUserTokenCount().intValue();
        return ++countOfWaitingUserToken;
    }
}
