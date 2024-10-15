package com.consertreservation.api.usertoken;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.consertreservation.TestConfig;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTokenControllerTest extends TestConfig {

    /**
     * When: 유저 토큰을 조회를 하면
     * Then: 유저 토큰이 반환이 된다.
     */
    @Test
    @DisplayName("유저 토큰 발급")
    void test() {
        // When
        int userId = 1;
        JsonPath userToken = RestAssured.given()
                .queryParam("user_id", userId)
                .log().all().when()
                .get("/v1/usertoken")
                .then().log().all().extract().jsonPath();

        System.out.println("userToken = " + userToken);
        // Then
        assertThat(userToken.getLong("userId")).isEqualTo(userId);
        assertThat(userToken.getString("status")).isEqualTo("WAIT");
    }
}