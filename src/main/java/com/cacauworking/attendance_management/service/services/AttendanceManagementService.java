package com.cacauworking.attendance_management.service.services;

import com.cacauworking.attendance_management.domain.AttendanceManagement;

import java.util.List;

public interface AttendanceManagementService {

    List<AttendanceManagement> findAll();
    AttendanceManagement findById(String overtime);
    AttendanceManagement save(AttendanceManagement attendanceManagement);
    AttendanceManagement update(AttendanceManagement attendanceManagement);
    void deleteByDocument(Long id);
}
