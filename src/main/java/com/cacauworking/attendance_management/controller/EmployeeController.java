package com.cacauworking.attendance_management.controller;

import com.cacauworking.attendance_management.domain.Employee;
import com.cacauworking.attendance_management.domain.Status;
import com.cacauworking.attendance_management.dto.employeedto.EmployeeGetDTO;
import com.cacauworking.attendance_management.dto.employeedto.EmployeeSaveDTO;
import com.cacauworking.attendance_management.dto.employeedto.EmployeeSetDataDTO;
import com.cacauworking.attendance_management.mapper.EmployeeMapper;
import com.cacauworking.attendance_management.service.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/funcionarios")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;
    private final EmployeeMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeGetDTO save(@Valid @RequestBody EmployeeSaveDTO dto) {
        Employee employee = service.save(mapper.employeeSaveDTOToEmployee(dto));
        return mapper.employeeToEmployeeGetDTO(employee);
    }

    @GetMapping("{document}")
    public EmployeeGetDTO findByDocument(@PathVariable String document) {
        Employee employee = service.findByDocument(document);
        return mapper.employeeToEmployeeGetDTO(employee);
    }

    @GetMapping
    public List<EmployeeGetDTO> findAll() {
        List<Employee> employees = service.findAll();
        return employees
                .stream()
                .map(mapper::employeeToEmployeeGetDTO)
                .toList();
    }

    @GetMapping("ativos")
    public List<EmployeeGetDTO> findAllByStatus() {
        List<Employee> employees = service.findAllByStatus(Status.ATIVO);
        return employees
                .stream()
                .map(mapper::employeeToEmployeeGetDTO)
                .toList();
    }

    @PutMapping("dados/{document}")
    public EmployeeGetDTO updateData(@PathVariable String document, @RequestBody EmployeeSetDataDTO dto) {
        Employee employee = service.findByDocument(document);
        employee.setDocument(dto.getDocument());
        employee.setName(dto.getName());
        employee.setBirth(dto.getBirth());
        employee.setStatus(dto.getStatus());

        return mapper.employeeToEmployeeGetDTO(
                service.update(employee));
    }

    @DeleteMapping("{document}")
    public void delete(@PathVariable String document) {
        service.delete(service.findByDocument(document));
    }
}
