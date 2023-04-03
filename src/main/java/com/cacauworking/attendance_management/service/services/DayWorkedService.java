package com.cacauworking.attendance_management.service.services;

import com.cacauworking.attendance_management.domain.DayWorked;

import java.util.List;

public interface DayWorkedService {
    List<DayWorked> findAll();
    DayWorked findByDocument(String id);
    DayWorked save(DayWorked dayWorked);
    DayWorked update(DayWorked dayWorked);
    void deleteByDocument(String document);
}
