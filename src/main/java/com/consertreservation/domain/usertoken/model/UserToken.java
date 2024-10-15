package com.consertreservation.domain.usertoken.model;

import com.consertreservation.domain.base.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
        this.waitingOrder = waitingOrder;
    }
}
