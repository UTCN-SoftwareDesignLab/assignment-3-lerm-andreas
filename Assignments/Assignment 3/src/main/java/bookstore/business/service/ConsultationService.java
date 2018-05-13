package bookstore.business.service;

import bookstore.business.dto.ConsultationDto;
import bookstore.business.dto.PatientDto;
import bookstore.data.entity.Consultation;
import bookstore.data.entity.Patient;

import javax.transaction.Transactional;
import java.util.List;

public interface ConsultationService {

    @Transactional
    List<Consultation> getAll();
    @Transactional
    Consultation createConsultation(ConsultationDto consultationDto);

    @Transactional
    void deleteConsultation(ConsultationDto consultationDto);


    List<Consultation> findByPatient(PatientDto patientDto);

    @Transactional
    Consultation updateConsultation(ConsultationDto consultationDto);


}
