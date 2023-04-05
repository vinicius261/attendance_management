package com.cacauworking.attendance_management.service.services;

import com.cacauworking.attendance_management.domain.AttendanceManagement;
import com.cacauworking.attendance_management.dto.AttendanceManagementGetDTO;

import java.time.Duration;
import java.util.List;

public interface AttendanceManagementService {

    List<AttendanceManagement> findAll();
    AttendanceManagement save(AttendanceManagement attendanceManagement);
    AttendanceManagement findByEmployee(String documentoFuncionario);

    Duration calculateOvertime(AttendanceManagement byEmployee);
}
