package com.cacauworking.attendance_management.dto.contractdto;

import com.cacauworking.attendance_management.domain.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ContractUpdateDTO {

    private String contractNumber;
    private LocalDate start;
    private LocalDate end;
    private Status status;
}
