package com.consertreservation.domain.usertoken.respositories;

import com.consertreservation.domain.user.User;
import com.consertreservation.domain.usertoken.model.UserToken;

public interface UserTokenStoreRepository {
    UserToken save(UserToken userToken);
}
