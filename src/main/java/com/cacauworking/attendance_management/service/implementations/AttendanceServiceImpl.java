package com.cacauworking.attendance_management.service.implementations;

import com.cacauworking.attendance_management.domain.AttendanceManagement;
import com.cacauworking.attendance_management.domain.Contract;
import com.cacauworking.attendance_management.domain.DayWorked;
import com.cacauworking.attendance_management.domain.Status;
import com.cacauworking.attendance_management.dto.HolidayDTO;
import com.cacauworking.attendance_management.exceptions.FogetToRegisterException;
import com.cacauworking.attendance_management.repository.AttendanceManagementRepository;
import com.cacauworking.attendance_management.repository.ContractRepository;
import com.cacauworking.attendance_management.repository.EmployeeRepository;
import com.cacauworking.attendance_management.service.services.AttendanceManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceManagementService {

    private final AttendanceManagementRepository repository;
    private final ContractRepository contractRepository;

    private final EmployeeRepository employeeRepository;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public AttendanceManagement save(AttendanceManagement attendanceManagement) {
        return repository.save(attendanceManagement);
    }

    @Override
    public List<AttendanceManagement> findAll() {
        return (List<AttendanceManagement>) repository.findAll();
    }

    @Override
    public AttendanceManagement findByEmployee(String documentoFuncionario) {
        Contract activeContract = contractRepository.findByEmployeeAndStatus(
                employeeRepository.findByDocument(documentoFuncionario), Status.ATIVO);
        return activeContract.getAttendanceManagement();
    }

    @Override
    public AttendanceManagement calculateOvertime(AttendanceManagement attendance) {
        List<DayWorked> daysWorked = attendance.getWorkedDays();

        Duration overtime = Duration.ZERO;

        for (DayWorked day : daysWorked) {
            Duration hoursPerContract = Duration.between(LocalTime.of(9, 00), LocalTime.of(18, 00))
                    .minus(Duration.of(1l, ChronoUnit.MINUTES));

            try {
                Duration morningHours = Duration.between(day.getEntryTime(), day.getLunchBegin());
                Duration afternoonHours = Duration.between(day.getLunchEnd(), day.getLeavingTime());
                Duration totalDayHours = morningHours.plus(afternoonHours);

                Duration extra = totalDayHours.minus(hoursPerContract);
                if (isFeriado(day.getDate().getYear())) {
                    overtime.plus(extra.multipliedBy(2));
                }

                overtime = overtime.plus(extra);
            } catch (NullPointerException ex) {
                if (day.getDate().equals(LocalDate.now())) {
                    break;
                }

                throw new FogetToRegisterException();
            }
        }

        attendance.setOvertime(overtime);

        return attendance;
    }

    public boolean isFeriado(Integer year) {
        String url = "https://brasilapi.com.br/api/feriados/v1/" + year;
        ResponseEntity<List<HolidayDTO>> response = restTemplate
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<HolidayDTO>>() {
                });

        if (response.getBody().stream()
                .anyMatch(localDate -> localDate.equals(LocalDate.now()))) {
            return true;
        }

        return false;
    }
}
