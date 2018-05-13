package bookstore.data.repository;

import bookstore.data.entity.Patient;
import bookstore.data.entity.User1;
import javafx.scene.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAll();

   // P save(Patient patient);

    Patient findByIdentityCardNumber(Long identityCardNumber);
    Patient findByName(String name);
    @Modifying
    @Transactional
    @Query("update Patient p set p.personalNumericalCode = ?1, p.address= ?2 where p.identityCardNumber = ?3")
    void updatePatient(String personalNumericalCode,String address,Long identityCardNumber);
}
