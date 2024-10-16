package com.consertreservation.domain.usertoken.infra;

import static com.consertreservation.domain.usertoken.model.QUserToken.userToken;

import com.consertreservation.domain.usertoken.model.TokenStatus;
import com.consertreservation.domain.usertoken.model.UserToken;
import com.consertreservation.domain.usertoken.respositories.UserTokenReaderRepository;
import com.querydsl.jpa.JPQLQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserTokenReaderCustomRepository implements UserTokenReaderRepository {

    private final JPQLQueryFactory queryFactory;

    @Override
    public Optional<UserToken> getUserToken(Long userId) {
        return Optional.ofNullable(queryFactory.selectFrom(userToken)
                .where(userToken.userId.eq(userId))
                .fetchFirst());
    }

    @Override
    public Long getWaitOfUserTokenCount() {
        return queryFactory.select(userToken.count())
                .from(userToken)
                .where(userToken.status.eq(TokenStatus.WAIT))
                .fetchCount();
    }
}
