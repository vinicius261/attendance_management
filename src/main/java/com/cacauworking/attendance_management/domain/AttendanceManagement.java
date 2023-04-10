package com.cacauworking.attendance_management.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("attendanceManagement")
    private Contract contract;
    private Duration overtime;
    @OneToMany(mappedBy = "attendanceManagement")
    private List<DayWorked> workedDays;
    @OneToMany(mappedBy = "attendanceManagement")
    private List<MedicalLicense> medicalLicenses;
    @OneToMany(mappedBy = "attendanceManagement")
    private List<Vacation> vacations;

}
