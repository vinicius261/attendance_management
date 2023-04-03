package com.cacauworking.attendance_management.repository;

import com.cacauworking.attendance_management.domain.DayWorked;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayWorkedRepository extends CrudRepository<DayWorked, Long> {
}
