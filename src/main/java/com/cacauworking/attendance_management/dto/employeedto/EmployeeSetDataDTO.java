package com.cacauworking.attendance_management.dto.employeedto;

import com.cacauworking.attendance_management.domain.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeSetDataDTO {

    private String document;
    private String name;
    private LocalDate birth;
    private Status status;
}
