package com.rom.tr.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class ReservationResponse {
    private boolean isReserved;
    private String token;
}
