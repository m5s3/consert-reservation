package com.consertreservation.api.usertoken;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usertoken")
public class UserTokenController {

    @PostMapping
    public ResponseEntity getUserToken() {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getUserToken(@RequestHeader String userTokenId) {
        return ResponseEntity.ok().build();
    }
}
