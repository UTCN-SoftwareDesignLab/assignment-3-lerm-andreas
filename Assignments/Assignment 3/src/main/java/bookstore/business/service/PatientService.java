package bookstore.business.service;

import bookstore.business.dto.PatientDto;
import bookstore.data.entity.Patient;

import javax.transaction.Transactional;
import java.util.List;

public interface PatientService  {
    @Transactional
    List<Patient> getAll();

    @Transactional
    Patient createPatient(PatientDto patientDto);

    @Transactional
    void deletePatient(PatientDto patientDto);

    @Transactional
    Patient getPatient(PatientDto patientDto);

    @Transactional
    void updatePatient(PatientDto patientDto);

    Patient findByIdentityCardNumber(Long identityCardNumber);

}
