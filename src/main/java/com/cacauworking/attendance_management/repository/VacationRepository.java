package com.cacauworking.attendance_management.repository;

import com.cacauworking.attendance_management.domain.Vacation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRepository extends CrudRepository<Vacation, Long> {
}
