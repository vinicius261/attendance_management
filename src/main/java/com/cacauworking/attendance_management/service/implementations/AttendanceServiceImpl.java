package com.cacauworking.attendance_management.service.implementations;

import com.cacauworking.attendance_management.domain.AttendanceManagement;
import com.cacauworking.attendance_management.repository.AttendanceManagementRepository;
import com.cacauworking.attendance_management.service.services.AttendanceManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceManagementService {

    private final AttendanceManagementRepository repository;

    @Override
    public List<AttendanceManagement> findAll() {
        return (List<AttendanceManagement>) repository.findAll();
    }

    @Override
    public AttendanceManagement findById(String overtime) {
        /*AttendanceManagement attendanceManagement = repository.findByOvertime(overtime);
        if(attendanceManagement == null){
            throw new DataNotFoundException("Registro de ponto não encontrado.);
        }*/
        return null;
    }

    @Override
    public AttendanceManagement save(AttendanceManagement attendanceManagement) {
        return repository.save(attendanceManagement);
    }

    @Override
    public AttendanceManagement update(AttendanceManagement attendanceManagement) {
        return null;
    }

    @Override
    public void deleteByDocument(Long id) {

    }
}
