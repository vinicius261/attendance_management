package com.cacauworking.attendance_management.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class AttendanceOvertimeDTO {

    private Duration overtime;
}
