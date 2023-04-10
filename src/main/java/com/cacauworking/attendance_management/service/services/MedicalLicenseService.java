package com.cacauworking.attendance_management.service.services;

import com.cacauworking.attendance_management.domain.MedicalLicense;

import java.util.List;

public interface MedicalLicenseService {
    List<MedicalLicense> findAll();

    MedicalLicense findByDocument(String id);

    MedicalLicense save(MedicalLicense medicalLicense);

    MedicalLicense update(MedicalLicense medicalLicense);

    void deleteByDocument(MedicalLicense document);
}
