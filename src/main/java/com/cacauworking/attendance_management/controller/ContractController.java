package com.cacauworking.attendance_management.controller;

import com.cacauworking.attendance_management.domain.AttendanceManagement;
import com.cacauworking.attendance_management.domain.Contract;
import com.cacauworking.attendance_management.domain.Status;
import com.cacauworking.attendance_management.dto.contractdto.*;
import com.cacauworking.attendance_management.mapper.ContractMapper;
import com.cacauworking.attendance_management.service.services.ContractService;
import com.cacauworking.attendance_management.service.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/contratos")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;
    private final EmployeeService employeeService;
    private final ContractMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContractGetDTO save (@RequestBody ContractSaveDTO dto){
        Contract contract = Contract.builder()
                .employee(employeeService.findByDocument(dto.getEmployeeDocument()))
                .contractNumber(dto.getContractNumber())
                .start(dto.getStart())
                .status(Status.ATIVO)
                .build();


        return mapper.contractToContractGetDTO(
                contractService.save(contract));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContractGetDTO> findAll(){
        return mapper.listContractToListContractGetDTO(contractService.findAll());
    }

    @GetMapping("{contractNumber}")
    public ContractGetDTO findByNumber(@PathVariable String contractNumber){
        return mapper.contractToContractGetDTO(
                contractService.findByContractNumber(
                        contractNumber));
    }

    @GetMapping("status")
    public List<ContractGetDTO> findAllByStatus(@RequestBody ContractStatusDTO dto){
        return  contractService
                .findAllByStatus(dto.getStatus())
                .stream().map(mapper::contractToContractGetDTO)
                .toList();
    }

    @GetMapping("/funcionario/{documentoFuncionario}")
    public List<ContractGetDTO> findAllByEmployee(@PathVariable String documentoFuncionario){
        return  contractService
                .findAllByEmployee(employeeService.findByDocument(documentoFuncionario))
                .stream().map(mapper::contractToContractGetDTO)
                .toList();
    }

    @PutMapping("dados/{contractNumber}")
    public ContractGetDTO updateData(@PathVariable String contractNumber, @RequestBody ContractUpdateDTO dto){
        Contract contract = contractService.findByContractNumber(contractNumber);
        contract.setContractNumber(dto.getContractNumber());
        contract.setStart(dto.getStart());
        contract.setEnd(dto.getEnd());
        contract.setStatus(dto.getStatus());
        return mapper.contractToContractGetDTO(contractService.update(contract));
    }

    @PutMapping("encerrar/{contractNumber}")
    public ContractGetDTO updateStatus(@PathVariable String contractNumber, @RequestBody ContractEndDTO dto){
        Contract contract = contractService.findByContractNumber(
                contractNumber);
        contract.setEnd(dto.getEnd());
        return mapper.contractToContractGetDTO(contractService.updateEnd(contract));
    }

    @DeleteMapping("{contractNumber}")
    public void delete(@PathVariable String contractNumber){
        contractService.delete(
                contractService.findByContractNumber(
                        contractNumber));
    }
}
