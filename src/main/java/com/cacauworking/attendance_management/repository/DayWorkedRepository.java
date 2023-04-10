package com.cacauworking.attendance_management.repository;

import com.cacauworking.attendance_management.domain.AttendanceManagement;
import com.cacauworking.attendance_management.domain.DayWorked;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DayWorkedRepository extends CrudRepository<DayWorked, Long> {

    DayWorked findByAttendanceManagementAndDate(AttendanceManagement attendance, LocalDate date);

    List<DayWorked> findAllByAttendanceManagement(AttendanceManagement attendance);
}
