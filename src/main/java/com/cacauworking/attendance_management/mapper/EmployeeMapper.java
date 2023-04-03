package com.cacauworking.attendance_management.mapper;

import com.cacauworking.attendance_management.domain.Employee;
import com.cacauworking.attendance_management.dto.employeedto.EmployeeGetDTO;
import com.cacauworking.attendance_management.dto.employeedto.EmployeeSaveDTO;
import com.cacauworking.attendance_management.dto.employeedto.EmployeeSetDataDTO;
import com.cacauworking.attendance_management.dto.employeedto.EmployeeSetStatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee employeeSaveDTOToEmployee(EmployeeSaveDTO dto);

    EmployeeGetDTO employeeToEmployeeGetDTO(Employee employee);

    Employee employeeSetDataDTOToEmployee(EmployeeSetDataDTO dto);

    Employee employeeSetStatusDTOToEmployee(EmployeeSetStatusDTO dto);
}
