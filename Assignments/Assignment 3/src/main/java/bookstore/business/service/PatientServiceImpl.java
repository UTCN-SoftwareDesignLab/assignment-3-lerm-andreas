package bookstore.business.service;

import bookstore.business.dto.PatientDto;
import bookstore.data.entity.Patient;
import bookstore.data.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientServiceImpl implements  PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(final PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }



    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient createPatient(PatientDto patientDto) {
        Patient patient = new Patient(patientDto.getName(),patientDto.getIdentityCardNumber(),patientDto.getPersonalNumericalCode(),patientDto.getDateOfBirth(),patientDto.getAddress());
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public void deletePatient(PatientDto patientDto) {
        Patient patient = patientRepository.findByIdentityCardNumber(patientDto.getIdentityCardNumber());
        patientRepository.delete(patient);
    }

    @Override
    public Patient getPatient(PatientDto patientDto) {
        return patientRepository.findByIdentityCardNumber(patientDto.getIdentityCardNumber());
    }

    @Override
    public void updatePatient(PatientDto patientDto) {
        patientRepository.updatePatient(patientDto.getPersonalNumericalCode(),patientDto.getAddress(),patientDto.getIdentityCardNumber());
    }

    @Override
    public Patient findByIdentityCardNumber(Long identityCardNumber){
        return patientRepository.findByIdentityCardNumber(identityCardNumber);
    }
}
