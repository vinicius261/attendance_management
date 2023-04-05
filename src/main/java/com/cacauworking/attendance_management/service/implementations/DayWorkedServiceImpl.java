package com.cacauworking.attendance_management.service.implementations;

import com.cacauworking.attendance_management.domain.AttendanceManagement;
import com.cacauworking.attendance_management.domain.DayWorked;
import com.cacauworking.attendance_management.exceptions.DataNotFoundException;
import com.cacauworking.attendance_management.repository.AttendanceManagementRepository;
import com.cacauworking.attendance_management.repository.DayWorkedRepository;
import com.cacauworking.attendance_management.service.services.AttendanceManagementService;
import com.cacauworking.attendance_management.service.services.DayWorkedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DayWorkedServiceImpl implements DayWorkedService {

    private final DayWorkedRepository repository;

    @Override
    public void save(AttendanceManagement attendance) {
        DayWorked dayWorked = DayWorked.builder()
                .date(LocalDate.now())
                .attendanceManagement(attendance)
                .entryTime(LocalDateTime.now())
                .build();

        repository.save(dayWorked);
    }

    @Override
    public void saveLunchBegin(AttendanceManagement attendance) {
        DayWorked dayWorked = repository.findByAttendanceManagementAndDate(attendance, LocalDate.now());
        if(dayWorked == null){
            throw new DataNotFoundException("Para registrar almoço precisa ter registrado a entrada.");
        }
        dayWorked.setLunchBegin(LocalDateTime.now());
        repository.save(dayWorked);
    }

    @Override
    public void saveLunchEnd(AttendanceManagement attendance) {
        DayWorked dayWorked = repository.findByAttendanceManagementAndDate(attendance, LocalDate.now());
        if(dayWorked.getLunchBegin() == null){
            throw new DataNotFoundException("Para registrar o fim almoço precisa ter registrado a entrada.");
        }
        dayWorked.setLunchEnd(LocalDateTime.now());
        repository.save(dayWorked);
    }

    @Override
    public void saveLeaveTime(AttendanceManagement attendance) {
        DayWorked dayWorked = repository.findByAttendanceManagementAndDate(attendance, LocalDate.now());
        if(dayWorked.getLunchEnd() == null){
            throw new DataNotFoundException("Para registrar a saída precisa ter registrado o fim do almoço.");
        }
        dayWorked.setLeavingTime(LocalDateTime.now());
        repository.save(dayWorked);
    }

    @Override
    public List<DayWorked> findAllByEmployee(AttendanceManagement attendance) {
        return repository.findAllByAttendanceManagement(attendance);
    }
}
