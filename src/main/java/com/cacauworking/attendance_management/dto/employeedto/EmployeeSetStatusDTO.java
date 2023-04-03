package com.cacauworking.attendance_management.dto.employeedto;

import com.cacauworking.attendance_management.domain.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeSetStatusDTO {
    private Status status;
}
