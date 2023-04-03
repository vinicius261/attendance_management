package com.cacauworking.attendance_management.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String contractNumber;
    private LocalDate start;
    private LocalDate end;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne(mappedBy = "contract")
    private AttendanceManagement attendanceManagement;
    @JsonIgnoreProperties("contracts")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
}
