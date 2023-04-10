package com.cacauworking.attendance_management.mapper;

import com.cacauworking.attendance_management.domain.DayWorked;
import com.cacauworking.attendance_management.dto.DayWorkedDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DayWorkedMapper {

    List<DayWorkedDTO> listDayWorkedDTOToListDayWorked(List<DayWorked> list);

}
