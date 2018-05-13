package bookstore.business.dto;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class PatientDto {

    @Size(min=3,message = "The name must consist of at least 3 characters!")
    private String name;
    private Long identityCardNumber;

    @Size(min=5,max=5,message = "The personal numerical code must consist of exactly 5 characters!")
    private String personalNumericalCode;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Size(min=5,message = "The description must consist of at least 5 characters")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(Long identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getPersonalNumericalCode() {
        return personalNumericalCode;
    }

    public void setPersonalNumericalCode(String personalNumericalCode) {
        this.personalNumericalCode = personalNumericalCode;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
