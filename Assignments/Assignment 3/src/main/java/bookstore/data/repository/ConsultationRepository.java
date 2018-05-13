package bookstore.data.repository;

import bookstore.business.dto.PatientDto;
import bookstore.business.dto.UserDto1;
import bookstore.data.entity.Consultation;
import bookstore.data.entity.Patient;
import bookstore.data.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

   // Consultation findByPatientAndDoctorAndDate(PatientDto patientDto, UserDto1 userDto1, Date date);
    List<Consultation> findByPatientAndDateBefore (Patient patient,Date date);
    Consultation findById(Long id);
    Consultation findByDoctorAndPatientAndDate(User1 doctor,Patient patient,Date date);
    @Modifying
    @Transactional
    @Query("update Consultation c set c.description = ?1 where c.id = ?2")
    void updateConsultation(String description, Long id);
}
