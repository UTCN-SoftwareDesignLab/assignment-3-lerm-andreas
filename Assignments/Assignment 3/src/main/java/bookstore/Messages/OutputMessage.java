package bookstore.Messages;

import java.util.Date;

public class OutputMessage
{
    /*private String from;
    private String message;
    private String topic;
    private Date time = new Date();

    public OutputMessage() {}

    public OutputMessage(String from,String message,String topic)
    {
        this.from = from;
        this.message = message;
        this.topic = topic;
    }

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getTopic()
    {
        return topic;
    }

    public void setTopic(String topic)
    {
        this.topic = topic;
    }

    public Date getTime()
    {
        return time;
    }*/

    private String patientName;
    private String doctorName;
    private Date date;

    public OutputMessage() {
    }

    public OutputMessage(String patientName, String doctorName, Date date) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}