package bookstore.business.service;

import bookstore.business.dto.ConsultationDto;
import bookstore.business.dto.PatientDto;
import bookstore.data.entity.Consultation;

import java.util.List;

public class CachingConsultationService implements ConsultationService {

    private ConsultationService origin;

    public CachingConsultationService(ConsultationService origin){
        this.origin=origin;
    }

    @Override
    public List<Consultation> getAll() {
        return origin.getAll();
    }

    @Override
    public Consultation createConsultation(ConsultationDto consultationDto) {
        return origin.createConsultation(consultationDto);
    }

    @Override
    public void deleteConsultation(ConsultationDto consultationDto) {
        origin.deleteConsultation(consultationDto);
    }

    @Override
    public List<Consultation> findByPatient(PatientDto patientDto){
        return origin.findByPatient(patientDto);
    }

    @Override
    public Consultation updateConsultation(ConsultationDto consultationDto) {
        return origin.updateConsultation(consultationDto);
    }


}
