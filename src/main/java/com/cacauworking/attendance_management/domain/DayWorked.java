package com.cacauworking.attendance_management.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DayWorked {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JsonIgnoreProperties("workedDays")
    private AttendanceManagement attendanceManagement;
    private LocalDate date;
    private LocalDateTime entryTime;
    private LocalDateTime lunchBegin;
    private LocalDateTime lunchEnd;
    private LocalDateTime leavingTime;
}
