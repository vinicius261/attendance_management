package com.cacauworking.attendance_management.service.services;

import com.cacauworking.attendance_management.domain.AttendanceManagement;
import com.cacauworking.attendance_management.domain.DayWorked;

import java.util.List;

public interface DayWorkedService {
    List<DayWorked> findAllByEmployee(AttendanceManagement attendance);
    void save(AttendanceManagement attendanceManagement);
    void saveLunchBegin(AttendanceManagement attendance);

    void saveLunchEnd(AttendanceManagement attendance);

    void saveLeaveTime(AttendanceManagement attendance);
}
