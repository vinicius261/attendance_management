package com.cacauworking.attendance_management.dto.contractdto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ContractSaveDTO {

    private String contractNumber;
    private String employeeDocument;
    private LocalDate start;
}
