package com.cacauworking.attendance_management.repository;

import com.cacauworking.attendance_management.domain.Employee;
import com.cacauworking.attendance_management.domain.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findByDocument(String document);

    List<Employee> findAllByStatus(Status status);

    boolean existsByDocument(String document);
}
