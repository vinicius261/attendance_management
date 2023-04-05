package com.cacauworking.attendance_management.dto;

import com.cacauworking.attendance_management.domain.Contract;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class AttendanceManagementGetDTO {

    private Contract contract;
    private Duration overtime;
}
