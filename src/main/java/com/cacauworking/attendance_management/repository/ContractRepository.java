package com.cacauworking.attendance_management.repository;

import com.cacauworking.attendance_management.domain.Contract;
import com.cacauworking.attendance_management.domain.Employee;
import com.cacauworking.attendance_management.domain.Status;
import org.hibernate.sql.results.graph.embeddable.EmbeddableLoadingLogger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Long> {
    Contract findByContractNumber(String contractNumber);
    List<Contract> findAll();
    List<Contract> findAllByStatus(Status status);
    List<Contract> findAllByEmployee(Employee employee);
    Contract findByEmployeeAndStatus(Employee employee, Status status);
    boolean existsByContractNumber(String contractNumber);

}
