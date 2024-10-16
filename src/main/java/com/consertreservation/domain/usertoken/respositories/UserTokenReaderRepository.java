package com.consertreservation.domain.usertoken.respositories;

import com.consertreservation.domain.usertoken.model.UserToken;
import java.util.Optional;

public interface UserTokenReaderRepository {
    Optional<UserToken> getUserToken(Long userId);
    Long getWaitOfUserTokenCount();
}
