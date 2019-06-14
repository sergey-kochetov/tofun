package com.forfun.park.payloads;

import lombok.Data;

@Data
public class IssueDtoRequest {

    private Long id;

    private String title;

    private String body;

    private Long userId;

    private String lat;

    private String lng;
}
