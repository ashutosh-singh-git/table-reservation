package com.rom.tr.dto;

import lombok.Builder;

@Builder
public class ApiResponse<K> {
    private boolean isSuccess;
    private String message;
    private K data;
}
