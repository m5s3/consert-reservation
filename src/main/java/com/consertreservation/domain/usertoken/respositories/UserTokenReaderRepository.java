package com.consertreservation.domain.usertoken.respositories;

import com.consertreservation.domain.usertoken.model.UserToken;

public interface UserTokenReaderRepository {
    UserToken getUserToken(Long userId);
    Long getWaitOfUserTokenCount();
}
