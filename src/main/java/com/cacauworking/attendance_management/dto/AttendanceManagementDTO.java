package com.cacauworking.attendance_management.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class AttendanceManagementDTO {

    private Duration overtime;

    public AttendanceManagementDTO(){
        this.overtime = Duration.ZERO;
    }
}
