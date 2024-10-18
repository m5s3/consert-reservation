package com.consertreservation.domain.usertoken.model;

import static com.consertreservation.domain.usertoken.exception.UserTokenErrorCode.ALREADY_IN_EXPIRED;
import static com.consertreservation.domain.usertoken.exception.UserTokenErrorCode.INVALID_WAITING_ORDER;
import static com.consertreservation.domain.usertoken.exception.UserTokenErrorCode.UNAUTHORIZED;

import com.consertreservation.domain.base.BaseTimeEntity;
import com.consertreservation.domain.usertoken.exception.UserTokenException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_token")
public class UserToken extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_token_id")
    private UUID id;
    private int waitingOrder;

    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name="status", columnDefinition = "varchar(20)")
    private TokenStatus status;

    @Builder
    public UserToken(UUID id, Long userid, int waitingOrder, TokenStatus status) {
        this.id = id;
        this.userId = userid;
        this.waitingOrder = waitingOrder;
        this.status = status;
    }

    public void updateWaitingOrder(int waitingOrder) {
        if (waitingOrder < 0) {
            throw new UserTokenException(INVALID_WAITING_ORDER,
                    "대기 순서는 음수일 수가 없습니다. waitingOrder=%s".formatted(waitingOrder));
        }
        this.waitingOrder = waitingOrder;
    }

    public void changeStatus(TokenStatus status) {
        this.status = status;
    }

    public boolean validateAuthorization() {
        if (this.status != TokenStatus.SUCCESS) {
            throw new UserTokenException(UNAUTHORIZED, "해당 유저는 권한이 없습니다");
        }
        return true;
    }

    public void expire() {
        if (this.status == TokenStatus.EXPIRED) {
            throw new UserTokenException(ALREADY_IN_EXPIRED, "이미 만료된 토큰입니다");
        }
        this.status = TokenStatus.EXPIRED;
    }

    public boolean isExpire() {
        return this.status == TokenStatus.EXPIRED;
    }
}
