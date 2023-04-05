package com.cacauworking.attendance_management.service.implementations;

import com.cacauworking.attendance_management.domain.Contract;
import com.cacauworking.attendance_management.domain.Employee;
import com.cacauworking.attendance_management.domain.Status;
import com.cacauworking.attendance_management.exceptions.DataAlreadyExistisException;
import com.cacauworking.attendance_management.exceptions.DataNotFoundException;
import com.cacauworking.attendance_management.repository.ContractRepository;
import com.cacauworking.attendance_management.repository.EmployeeRepository;
import com.cacauworking.attendance_management.service.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final ContractRepository contractRepository;

    @Override
    public Employee save(Employee employee) {
        if(repository.existsByDocument(employee.getDocument())){
            throw new DataAlreadyExistisException("Consultora Show já cadastrada.");
        }
        employee.setStatus(Status.INATIVO);
        return repository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employess = (List<Employee>) repository.findAll();
        if(employess.isEmpty()){
            throw new DataNotFoundException("Ainda não exitem funcionários cadastrados.");
        }
        return employess;
    }

    @Override
    public List<Employee> findAllByStatus (Status status){
        List<Employee> employees = repository.findAllByStatus(status);
        if(employees.isEmpty()){
            throw new DataNotFoundException("Ainda não exitem funcionários " +
                    status.toString().toLowerCase() + "s.");
        }
        return employees;
    }

    @Override
    public Employee findByDocument(String document) {
        if(! repository.existsByDocument(document)){
            throw new DataNotFoundException("Consultora Show não encontrada.");
        }
        return repository.findByDocument(document);

    }

    @Override
    public Employee update(Employee employee) {
        employee.setId(employee.getId());
        employee.setName(employee.getName());
        employee.setBirth(employee.getBirth());
        employee.setStatus(employee.getStatus());
        return repository.save(employee);
    }

    @Override
    public Employee updateStatus(Employee employee) {
        employee.setStatus(employee.getStatus());
        /*List<Contract> activeContracts = employee.getContracts()
                .stream()
                .filter(contract -> contract.getStatus().equals(Status.ATIVO))
                .toList();
        activeContracts.get(0).setStatus(employee.getStatus());*/
        /*contractRepository.updateStatus(activeContracts.get(0));*/
        return repository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        repository.delete(employee);
    }
}
