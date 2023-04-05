package com.cacauworking.attendance_management.dto.contractdto;

import com.cacauworking.attendance_management.domain.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractStatusDTO {
    private String contractNumber;
    private Status status;
}
