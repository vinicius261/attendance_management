package com.cacauworking.attendance_management.service.services;

import com.cacauworking.attendance_management.domain.Employee;
import com.cacauworking.attendance_management.domain.Status;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);
    List<Employee> findAll();
    public List<Employee> findAllByStatus (Status status);
    Employee findByDocument(String id);
    Employee update(Employee employee);
    Employee updateStatus(Employee employeeSetStatusDTOToEmployee);
    void delete(Employee employee);
}
