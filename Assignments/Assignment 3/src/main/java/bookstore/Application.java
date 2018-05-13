
package bookstore;
import bookstore.business.service.*;
import bookstore.data.repository.ConsultationRepository;
import bookstore.data.repository.PatientRepository;
import bookstore.data.repository.UserRepository1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   @Bean(name = "UserService1")
    public UserService1 userService(UserRepository1 repository) {
        return new CachingUserService1(new UserServiceImpl1(repository));
    }

    @Bean(name = "PatientService")
    public PatientService patientService(PatientRepository patientRepository){
        return new CachingPatientService(new PatientServiceImpl(patientRepository));
    }

    @Bean(name = "ConsultationService")
    public ConsultationService consultationService(ConsultationRepository consultationRepository,PatientRepository patientRepository,UserRepository1 userRepository){
        return new CachingConsultationService(new ConsultationServiceImpl(consultationRepository,patientRepository,userRepository));
    }
}

