package com.consertreservation.domain.usertoken.components;

import com.consertreservation.domain.usertoken.components.dto.CreateUserTokenDto;
import com.consertreservation.domain.usertoken.model.TokenStatus;
import com.consertreservation.domain.usertoken.model.UserToken;
import com.consertreservation.domain.usertoken.respositories.UserTokenStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class UserTokenComponent {

    private final UserTokenStoreRepository storeRepository;

    public CreateUserTokenDto createToken(long userId) {
        UserToken userToken = UserToken.builder()
                .userid(userId)
                .status(TokenStatus.WAIT)
                .build();
        UserToken newUserToken = storeRepository.save(userToken);
        return CreateUserTokenDto.from(newUserToken);
    }
}
