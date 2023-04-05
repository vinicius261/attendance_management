package com.cacauworking.attendance_management.controller;

import com.cacauworking.attendance_management.domain.AttendanceManagement;
import com.cacauworking.attendance_management.dto.AttendanceManagementGetDTO;
import com.cacauworking.attendance_management.dto.HolidaysListDTO;
import com.cacauworking.attendance_management.mapper.AttendanceManagementMapper;
import com.cacauworking.attendance_management.service.services.AttendanceManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("registro-de-ponto")
@RequiredArgsConstructor
public class AttendanceManagementController {

    private final AttendanceManagementService service;
    private final AttendanceManagementMapper mapper;

    @GetMapping
    public List<AttendanceManagementGetDTO> findAll(){
        return mapper.listAttendanceManagementToListAttendanceManagementGetDTO(service.findAll());
    }

    @GetMapping("{documentoFuncionario}")
    public AttendanceManagementGetDTO findByEmployee(@PathVariable String documentoFuncionario){
        return mapper.attendanceManagementToAttendanceManagementGetDTO(service.findByEmployee(documentoFuncionario));
    }

    @GetMapping("banco-de-horas/{documentoFuncionario}")
    public Long getOvertime(@PathVariable String documentoFuncionario){
        return service.calculateOvertime(service.findByEmployee(documentoFuncionario)).toHours();
    }
}
