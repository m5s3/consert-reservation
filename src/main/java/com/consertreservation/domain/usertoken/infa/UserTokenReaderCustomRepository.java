package com.consertreservation.domain.usertoken.infa;

import static com.consertreservation.domain.usertoken.model.QUserToken.userToken;

import com.consertreservation.domain.usertoken.model.UserToken;
import com.consertreservation.domain.usertoken.respositories.UserTokenReaderRepository;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserTokenReaderCustomRepository implements UserTokenReaderRepository {

    private final JPQLQueryFactory queryFactory;

    @Override
    public UserToken getUserToken(Long userId) {
        return queryFactory.selectFrom(userToken)
                .where(userToken.userId.eq(userId))
                .fetchFirst();
    }
}
