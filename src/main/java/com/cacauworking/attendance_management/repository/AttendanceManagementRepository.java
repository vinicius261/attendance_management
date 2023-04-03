package com.cacauworking.attendance_management.repository;

import com.cacauworking.attendance_management.domain.AttendanceManagement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceManagementRepository extends CrudRepository<AttendanceManagement, Long> {
}
