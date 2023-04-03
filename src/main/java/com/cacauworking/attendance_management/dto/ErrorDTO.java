package com.cacauworking.attendance_management.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorDTO {
    private String message;
}
