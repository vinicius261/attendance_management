package com.cacauworking.attendance_management.dto.employeedto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeSaveDTO {

    private String name;
    private String document;
    private LocalDate birth;
}
