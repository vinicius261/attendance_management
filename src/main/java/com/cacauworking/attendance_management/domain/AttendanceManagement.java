package com.cacauworking.attendance_management.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceManagement {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private Contract contract;
    private String overtime;
    @OneToMany(mappedBy = "attendanceManagement")
    private List<DayWorked> workedDays;
    @OneToMany(mappedBy = "attendanceManagement")
    private List<MedicalLicense> medicalLicenses;
    @OneToMany(mappedBy = "attendanceManagement")
    private List<Vacation> vacations;

}
