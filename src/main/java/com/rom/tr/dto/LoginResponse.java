package com.rom.tr.dto;

import lombok.Builder;

@Builder
public class LoginResponse {
    private String token;
    private String uid;
}
