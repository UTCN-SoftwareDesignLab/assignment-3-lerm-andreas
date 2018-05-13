package bookstore.business.dto;

import bookstore.data.entity.Patient;
import bookstore.data.entity.User1;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class ConsultationDto {

    private Long id;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Size(min = 6, message = "The username of the doctor must consist of at least 6 characters!")
    private String doctorName;

    private Long patientIdentityCardNumber;

    @Size(min=5,message = "The description must consist of at least 5 characters")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Long getPatientIdentityCardNumber() {
        return patientIdentityCardNumber;
    }

    public void setPatientIdentityCardNumber(Long patientIdentityCardNumber) {
        this.patientIdentityCardNumber = patientIdentityCardNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }


    public String getDescription() {
        return description;
    }

}
