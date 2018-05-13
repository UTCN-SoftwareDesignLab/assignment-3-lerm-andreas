package bookstore.presentation;

import bookstore.business.dto.ConsultationDto;
import bookstore.business.dto.PatientDto;
import bookstore.business.service.ConsultationService;
import bookstore.business.service.PatientService;
import bookstore.data.entity.Consultation;
import bookstore.data.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    ConsultationService consultationService;

    @Autowired
    public DoctorController(final ConsultationService consultationService){
        this.consultationService=consultationService;
    }

    @GetMapping("/doctor")
    public String getDoctorPage(Model model) {
        return "doctorPage";
    }

    @PostMapping("/doctor")
    public String showDoctorPage(Model model) {
        return "doctorPage";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }


    @GetMapping("/getConsultationForm")
    public String getConsultationForm(Model model) {
        model.addAttribute("patient", new PatientDto());
        return "getConsultationForm";
    }

    @PostMapping("/getConsultationForm")
    public String getConsultationFormGet(@ModelAttribute("consultation") @Valid Patient patientDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "getConsultationForm";
        }

        return "getConsultationForm";
    }

    @PostMapping("/getConsultation")
    public ModelAndView getConsultation(@ModelAttribute PatientDto patientDto) {

        List<Consultation> consultationDtoList =  consultationService.findByPatient(patientDto);


        ModelAndView mav = new ModelAndView("consultation_list");

        mav.addObject("consultationDtoList", consultationDtoList);

        return mav;
    }

    @GetMapping("/updateConsultationForm")
    public String updateConsultationForm(Model model) {
        model.addAttribute("consultation", new ConsultationDto());
        return "updateConsultationForm";
    }

    @PostMapping("/updateConsultationForm")
    public String updateConsultationFormGet(@ModelAttribute("consultation") @Valid ConsultationDto consultationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateConsultationForm";
        }

        return "updateConsultationForm";
    }

    @PostMapping("/updateConsultation")
    public ModelAndView updateConsultation(@ModelAttribute("consultation") ConsultationDto consultationDto) {
        consultationService.updateConsultation(consultationDto);

        List<Consultation> consultationDtoList = consultationService.getAll();

        ModelAndView mav = new ModelAndView("consultation_list");

        mav.addObject("consultationDtoList", consultationDtoList);

        return mav;
    }

   /* @GetMapping("/getConsultations")
    public String findConsultationsForm(PatientDto patientDto){
        return "/getConsultations";
    }

    @PostMapping("/getConsultations")
    public ModelAndView getAllConsultationsByPatient(PatientDto patientDto){
        List<Consultation> consultationDtoList = consultationService.findByPatient(patientDto);
        ModelAndView mav = new ModelAndView("getConsultations");
        mav.addObject("consultationDtoList", consultationDtoList);
        return mav;
    }*/
}