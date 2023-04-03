package com.cacauworking.attendance_management.dto.contractdto;

import com.cacauworking.attendance_management.domain.Employee;
import com.cacauworking.attendance_management.domain.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ContractGetDTO {

    private Long id;
    private String contractNumber;
    private LocalDate start;
    private LocalDate end;
    private Status status;
    private Employee employee;
}
