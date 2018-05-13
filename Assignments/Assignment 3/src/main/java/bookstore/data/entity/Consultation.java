package bookstore.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User1 doctor;

    private String description;

    public Consultation(){}

    public Consultation(Date date, Patient patient, User1 doctor, String description) {
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(User1 doctor) {
        this.doctor = doctor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public Patient getPatient() {
        return patient;
    }

    public User1 getDoctor() {
        return doctor;
    }

    public String getDescription() {
        return description;
    }



}
