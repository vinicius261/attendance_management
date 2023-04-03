package com.cacauworking.attendance_management.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String document;
    private LocalDate birth;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "employee")
    private List<Contract> contracts;
}
