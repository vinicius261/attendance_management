package com.cacauworking.attendance_management.service.services;

import com.cacauworking.attendance_management.domain.Contract;
import com.cacauworking.attendance_management.domain.Employee;
import com.cacauworking.attendance_management.domain.Status;

import java.util.Arrays;
import java.util.List;

public interface ContractService {

    List<Contract> findAllByEmployee(Employee employee);

    Contract findByContractNumber(String number);
    Contract save(Contract contract);
    Contract update(Contract contract);

    Contract updateEnd(Contract contract);

    void delete(Contract contract);
    List<Contract> findAll();

    List<Contract> findAllByStatus(Status ativo);
}

