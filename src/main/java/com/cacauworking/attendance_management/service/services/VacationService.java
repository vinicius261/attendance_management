package com.cacauworking.attendance_management.service.services;

import com.cacauworking.attendance_management.domain.Vacation;

import java.util.List;

public interface VacationService {
    List<Vacation> findAll();
    Vacation findByDocument(String id);
    Vacation save(Vacation vacation);
    Vacation update(Vacation vacation);
    void deleteByDocument(String document);
}
