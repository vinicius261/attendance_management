package com.cacauworking.attendance_management.controller;

import com.cacauworking.attendance_management.domain.AttendanceManagement;
import com.cacauworking.attendance_management.service.services.AttendanceManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adimin/registrodeponto")
@RequiredArgsConstructor
public class AttendanceManagementController {

    private final AttendanceManagementService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AttendanceManagement save(@RequestBody AttendanceManagement attendanceManagement) {
        return null; /*service.save(new AttendanceManagement(attendanceManagement.getOvertime()));*/
    }

    @GetMapping("{id}")
    public AttendanceManagement findAll(@PathVariable String id){

        return service.findById(id);
    }
}
