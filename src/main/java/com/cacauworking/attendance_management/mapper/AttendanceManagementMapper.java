package com.cacauworking.attendance_management.mapper;

import com.cacauworking.attendance_management.domain.AttendanceManagement;
import com.cacauworking.attendance_management.dto.AttendanceManagementGetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttendanceManagementMapper {
    AttendanceManagementMapper INSTANCE = Mappers.getMapper(AttendanceManagementMapper.class);

    List<AttendanceManagementGetDTO> listAttendanceManagementToListAttendanceManagementGetDTO(List<AttendanceManagement> attendanceManagement);
    AttendanceManagementGetDTO attendanceManagementToAttendanceManagementGetDTO(AttendanceManagement attendanceManagement);
}
