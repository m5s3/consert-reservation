package com.consertreservation.api.usertoken;

import com.consertreservation.api.usecase.UserTokenUseCase;
import com.consertreservation.api.usertoken.dto.ResponseUserToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/usertoken")
@RequiredArgsConstructor
public class UserTokenController {

    private final UserTokenUseCase userTokenUseCase;

    @PostMapping
    public ResponseEntity getUserToken() {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ResponseUserToken> getUserToken(@RequestParam(name = "user_id") Long userId) {
        return ResponseEntity.ok().body(ResponseUserToken.fromUserTokenDto(userTokenUseCase.getUserToken(userId)));
    }
}
