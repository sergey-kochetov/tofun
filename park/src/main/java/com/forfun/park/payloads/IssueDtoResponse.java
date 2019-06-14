package com.forfun.park.payloads;

import lombok.Data;

@Data
public class IssueDtoResponse {

    private Long id;

    private String title;

    private String body;

    private String imageUrl;

    private Long userId;

    private String lat;

    private String lng;
}
