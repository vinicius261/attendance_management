package com.cacauworking.attendance_management.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class DayWorkedDTO {

    private LocalDate date;
    private LocalDateTime entryTime;
    private LocalDateTime lunchBegin;
    private LocalDateTime lunchEnd;
    private LocalDateTime leavingTime;
}
