package bookstore.business.service;

import bookstore.business.dto.ConsultationDto;
import bookstore.business.dto.PatientDto;
import bookstore.data.entity.Consultation;
import bookstore.data.entity.Patient;
import bookstore.data.entity.User1;
import bookstore.data.repository.ConsultationRepository;
import bookstore.data.repository.PatientRepository;
import bookstore.data.repository.UserRepository1;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.LongToIntFunction;

public class ConsultationServiceImpl implements ConsultationService {

    private ConsultationRepository consultationRepository;
    private PatientRepository patientRepository;
    private UserRepository1 userRepository;

    @Autowired
    public ConsultationServiceImpl(final ConsultationRepository consultationRepository,PatientRepository patientRepository,UserRepository1 userRepository){
        this.consultationRepository = consultationRepository;
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Consultation> getAll() {
        return consultationRepository.findAll();
    }

    @Override
    public Consultation createConsultation(ConsultationDto consultationDto) {

        User1 doctor=userRepository.findByUserName(consultationDto.getDoctorName());
        Patient patient=patientRepository.findByIdentityCardNumber(consultationDto.getPatientIdentityCardNumber());
        Consultation consultation = new Consultation(consultationDto.getDate(),patient,doctor,consultationDto.getDescription());
        return consultationRepository.save(consultation);
    }

    @Override
    public void deleteConsultation(ConsultationDto consultationDto) {
        Consultation consultation = consultationRepository.findById(consultationDto.getId());
        consultationRepository.delete(consultation);
    }


    @Override
    public List<Consultation> findByPatient(PatientDto patientDto) {
        Patient patient=patientRepository.findByIdentityCardNumber(patientDto.getIdentityCardNumber());
        if(patient!=null){
            List<Consultation> consultations = consultationRepository.findByPatientAndDateBefore(patient,new Date());
            return consultations;
        }
        else
            return new ArrayList<>();
    }

    @Override
    public Consultation updateConsultation(ConsultationDto consultationDto) {
        Patient patient = patientRepository.findByIdentityCardNumber(consultationDto.getPatientIdentityCardNumber());
        User1 doctor = userRepository.findByUserName(consultationDto.getDoctorName());
        Date date = consultationDto.getDate();
        String newDescription = consultationDto.getDescription();
        Consultation consultation = consultationRepository.findByDoctorAndPatientAndDate(doctor,patient,date);
        Long id = consultation.getId();
         consultationRepository.updateConsultation(newDescription,id);
         return consultation;
    }
}
