package com.forfun.park.payloads;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String accessToken;

    private String tokenType = "Bear";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
