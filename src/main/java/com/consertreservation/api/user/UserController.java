package com.consertreservation.api.user;

import com.consertreservation.api.usecase.UserUseCase;
import com.consertreservation.api.user.dto.RequestCharge;
import com.consertreservation.api.user.dto.ResponseCharge;
import com.consertreservation.domain.user.components.dto.UserChargeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/charge")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @GetMapping
    public ResponseEntity<ResponseCharge> charge(@RequestParam(name = "user_id") Long userId) {
        UserChargeDto charge = userUseCase.getCharge(userId);
        return ResponseEntity.ok().body(ResponseCharge.of(charge.userId(), charge.amount()));
    }

    @PostMapping
    public ResponseEntity<ResponseCharge> charge(@RequestBody RequestCharge request) {
        UserChargeDto charge = userUseCase.charge(request.userId(), request.amount());
        return ResponseEntity.ok().body(ResponseCharge.of(charge.userId(), charge.amount()));
    }
}
