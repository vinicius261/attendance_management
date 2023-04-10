package com.cacauworking.attendance_management.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Contract {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String contractNumber;
    private LocalDate start;
    private LocalDate end;
    @Enumerated(EnumType.STRING)
    private Status status;
    @JsonIgnoreProperties("contract")
    @OneToOne(mappedBy = "contract", cascade = CascadeType.PERSIST)
    private AttendanceManagement attendanceManagement;
    @JsonIgnoreProperties("contracts")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
}
