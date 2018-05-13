package bookstore.business.service;

import bookstore.business.dto.PatientDto;
import bookstore.data.entity.Patient;

import java.util.List;

public class CachingPatientService implements PatientService {

    private PatientService origin;

    public CachingPatientService(PatientService origin){
        this.origin=origin;
    }

    @Override
    public List<Patient> getAll() {
        return origin.getAll();
    }

    @Override
    public Patient createPatient(PatientDto patientDto) {
        return origin.createPatient(patientDto);
    }

    @Override
    public void deletePatient(PatientDto patientDto) {
        origin.deletePatient(patientDto);
    }

    @Override
    public Patient getPatient(PatientDto patientDto) {
        return origin.getPatient(patientDto);
    }

    @Override
    public void updatePatient(PatientDto patientDto) {
        origin.updatePatient(patientDto);
    }

    @Override
    public Patient findByIdentityCardNumber(Long identityCardNumber) {
        return origin.findByIdentityCardNumber(identityCardNumber);
    }
}
