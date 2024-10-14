package com.consertreservation.api.payment;

import com.consertreservation.api.payment.dto.RequestPayment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {

    @PostMapping
    public ResponseEntity<Result> payment(@RequestHeader String userTokenId, @RequestBody RequestPayment request) {
        return ResponseEntity.ok().body(new Result("결제가 완료되었습니다."));
    }

    public static class Result {
        String message;

        public Result(String message) {
            this.message = message;
        }
    }
}
