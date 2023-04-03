package com.cacauworking.attendance_management.repository;

import com.cacauworking.attendance_management.domain.MedicalLicense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalLicenseRepository extends CrudRepository<MedicalLicense, Long> {
}
