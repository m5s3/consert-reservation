package com.consertreservation.api.charge;

import com.consertreservation.api.charge.dto.RequestCharge;
import com.consertreservation.api.charge.dto.ResponseCharge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/charge")
public class ChargeController {

    @GetMapping
    public ResponseEntity<Result> charge(@RequestHeader String userTokenId) {
        ResponseCharge responseCharge = new ResponseCharge(10000);
        return ResponseEntity.ok().body(new Result<>(responseCharge));
    }

    @PostMapping
    public ResponseEntity<Result> charge(@RequestHeader String userTokenId, @RequestBody RequestCharge request) {
        return ResponseEntity.ok().body(new Result<>("충전을 완료했습니다."));
    }

    public static class Result<T> {
        T data;
        String message;

        public Result(T data) {
            this.data = data;
        }

        public Result(String message) {
            this.message = message;
        }

        public Result(T data, String message) {
            this.data = data;
            this.message = message;
        }
    }
}
