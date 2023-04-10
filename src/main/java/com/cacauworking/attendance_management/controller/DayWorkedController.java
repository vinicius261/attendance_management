package com.cacauworking.attendance_management.controller;

import com.cacauworking.attendance_management.dto.DayWorkedDTO;
import com.cacauworking.attendance_management.mapper.DayWorkedMapper;
import com.cacauworking.attendance_management.service.services.AttendanceManagementService;
import com.cacauworking.attendance_management.service.services.DayWorkedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bater-ponto/{documentoFuncionario}")
@RequiredArgsConstructor
public class DayWorkedController {

    private final DayWorkedService service;
    private final AttendanceManagementService attendanceManagementService;
    private final DayWorkedMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewDay(@PathVariable String documentoFuncionario) {
        service.save(attendanceManagementService.findByEmployee(documentoFuncionario));
    }

    @PostMapping("entrada-almoco")
    @ResponseStatus(HttpStatus.CREATED)
    public void lunchBeginRegister(@PathVariable String documentoFuncionario) {
        service.saveLunchBegin(attendanceManagementService.findByEmployee(documentoFuncionario));
    }

    @PostMapping("saida-almoco")
    @ResponseStatus(HttpStatus.CREATED)
    public void lunchEndRegister(@PathVariable String documentoFuncionario) {
        service.saveLunchEnd(attendanceManagementService.findByEmployee(documentoFuncionario));
    }

    @PostMapping("saida")
    @ResponseStatus(HttpStatus.CREATED)
    public void leaveTimeRegister(@PathVariable String documentoFuncionario) {
        service.saveLeaveTime(attendanceManagementService.findByEmployee(documentoFuncionario));
    }

    @GetMapping("dias-trabalhados")
    public List<DayWorkedDTO> findDaysByEmployee(@PathVariable String documentoFuncionario) {
        return mapper.listDayWorkedDTOToListDayWorked(service.findAllByEmployee(attendanceManagementService.findByEmployee(documentoFuncionario)));
    }
}
