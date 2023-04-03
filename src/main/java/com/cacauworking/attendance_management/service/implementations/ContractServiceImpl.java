package com.cacauworking.attendance_management.service.implementations;

import com.cacauworking.attendance_management.domain.Contract;
import com.cacauworking.attendance_management.domain.Employee;
import com.cacauworking.attendance_management.domain.Status;
import com.cacauworking.attendance_management.exceptions.DataAlreadyExistisException;
import com.cacauworking.attendance_management.exceptions.DataNotFoundException;
import com.cacauworking.attendance_management.exceptions.InactiveContractException;
import com.cacauworking.attendance_management.repository.ContractRepository;
import com.cacauworking.attendance_management.service.services.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository repository;

    @Override
    public Contract save(Contract contract) {
        if(repository.existsByContractNumber(contract.getContractNumber())){
            throw new DataAlreadyExistisException("Esse contrato já existe");
        }
        return repository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        List<Contract> contracts = repository.findAll();
        if(contracts.isEmpty()){
            throw new DataNotFoundException("Ainda não exitem contratos cadastrados.");
        }
        return contracts;
    }

    @Override
    public List<Contract> findAllByStatus(Status status) {
        List<Contract> contracts = repository.findAllByStatus(status);
        if(contracts.isEmpty()){
            throw new DataNotFoundException("Ainda não exitem contratos " +
                    status.toString().toLowerCase() + "s.");
        }
        return contracts;
    }
    @Override
    public List<Contract> findAllByEmployee(Employee employee) {
        List<Contract> contracts = repository.findAllByEmployee(employee);
        if(contracts.isEmpty()){
            throw new DataNotFoundException("Ainda não exitem contratos de " +
                    employee.getName());
        }
        return repository.findAllByEmployee(employee);
    }

    @Override
    public Contract findByContractNumber(String number) {
        if(! repository.existsByContractNumber(number)){
            throw new DataNotFoundException("Contrato não encontrado");
        }
        return repository.findByContractNumber(number) ;
    }

    @Override
    public Contract update(Contract contract) {
        Contract contractToUpdate = findByContractNumber(contract.getContractNumber());
        contractToUpdate.setContractNumber(contractToUpdate.getContractNumber());
        contractToUpdate.setStart(contract.getStart());
        contractToUpdate.setEnd(contract.getEnd());
        contractToUpdate.setStatus(contract.getStatus());
        return repository.save(contract);
    }

    @Override
    public Contract updateEnd(Contract contract) {
        if(contract.getStatus().equals(Status.INATIVO)){
            throw new InactiveContractException();
        }
        contract.setStatus(Status.INATIVO);
        return repository.save(contract);
    }

    @Override
    public void delete(Contract contract) {
        repository.delete(contract);
    }
}
