package com.cacauworking.attendance_management.mapper;

import com.cacauworking.attendance_management.domain.Contract;
import com.cacauworking.attendance_management.dto.contractdto.ContractGetDTO;
import com.cacauworking.attendance_management.dto.contractdto.ContractUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ContractMapper {

    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    ContractGetDTO contractToContractGetDTO(Contract contract);

    Contract contractUpdateDTOToContract(ContractUpdateDTO dto);

    List<ContractGetDTO> listContractToListContractGetDTO(List<Contract> list);
}

