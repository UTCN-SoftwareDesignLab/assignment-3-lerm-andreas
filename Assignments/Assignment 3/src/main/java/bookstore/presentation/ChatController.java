package bookstore.presentation;


import bookstore.Messages.Message;
import bookstore.Messages.OutputMessage;
import bookstore.business.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Chat Controller listens for chat topic and responds with a message.
 *
 * @Author Jay Sridhar
 */
@Controller
public class ChatController
{
    @Autowired
    PatientService patientService;

    @MessageMapping("/chat/{topic}")
    @SendTo("/topic/messages")
    public OutputMessage send(@DestinationVariable("topic") String topic, Message message) throws Exception
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return new OutputMessage(patientService.findByIdentityCardNumber(Long.parseLong(message.getIdentityCardNumber())).getName(),message.getDoctorName(),simpleDateFormat.parse(message.getDate()));

    }

    @RequestMapping("/doctor")
    public String goDoctor(){
        return "doctorPage";
    }

    

}
