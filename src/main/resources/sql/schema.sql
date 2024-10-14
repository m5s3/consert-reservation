CREATE TABLE user_id
(
    `user_id`            BIGINT(20) NOT NULL AUTO_INCREMENT,
    `charge`             INT NULL COMMENT '충전금액',
    `created_at`         datetime(6) NOT NULL COMMENT '생성 일시',
    `updated_at`         datetime(6) NOT NULL COMMENT '수정 일시',
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
COMMENT '유저';

CREATE TABLE `user_token`
(
    `user_token_id`     BINARY(16) NOT NULL,
    `waiting_order`     INT(20) NOT NULL COMMENT '대기열 순서',
    `status`            VARCHAR(20) NOT NULL COMMENT '대기열 상태',
    `created_at`        datetime(6) NOT NULL COMMENT '생성 일시',
    `updated_at`        datetime(6) NOT NULL COMMENT '수정 일시',
    PRIMARY KEY (`user_token_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
COMMENT '유저 토큰';