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

import javax.jws.WebParam;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SecretaryController {

    @Autowired
    PatientService patientService;

    @Autowired
    ConsultationService consultationService;

    @Autowired
    public SecretaryController(final PatientService patientService,final ConsultationService consultationService) {
        this.patientService = patientService;
        this.consultationService = consultationService;
    }

    @GetMapping("/secretary")
    public String getSecretaryPage(Model model) {
        return "secretaryPage";
    }

    @PostMapping("/secretary")
    public String showSecretaryPage(Model model) {
        return "secretaryPage";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping("/createPatientForm")
    public String createPatientForm(Model model) {
        model.addAttribute("patient", new PatientDto());
        return "addPatientForm";
    }

    @PostMapping("/createPatientForm")
    public String createPatientFormGet(@ModelAttribute("patient") @Valid PatientDto patientDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addPatientForm";
        }

        return "addPatientForm";
    }

    @PostMapping("/createPatient")
    public ModelAndView createPatient(@ModelAttribute PatientDto patientDto) {
        patientService.createPatient(patientDto);
        List<Patient> patientDtoList = patientService.getAll();

        ModelAndView mav = new ModelAndView("patients_list");

        mav.addObject("patientDtoList", patientDtoList);

        return mav;
    }

    @GetMapping("/updatePatientForm")
    public String updatePatientForm(Model model) {
        model.addAttribute("patient", new PatientDto());
        return "updatePatientForm";
    }

    @PostMapping("/updatePatientForm")
    public String updatePatientFormGet(@ModelAttribute("patient") @Valid PatientDto patientDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updatePatientForm";
        }

        return "updatePatientForm";
    }

    @PostMapping("/updatePatient")
    public ModelAndView updatePatient(@ModelAttribute PatientDto patientDto) {
        patientService.updatePatient(patientDto);
        List<Patient> patientDtoList = patientService.getAll();

        ModelAndView mav = new ModelAndView("patients_list");

        mav.addObject("patientDtoList", patientDtoList);

        return mav;
    }


    @GetMapping("/createConsultationForm")
    public String createConsultationForm(Model model) {
        model.addAttribute("consultation", new ConsultationDto());
        return "addConsultationForm";
    }

    @PostMapping("/createConsultationForm")
    public String createConsultationFormGet(@ModelAttribute("consultation") @Valid ConsultationDto consultationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addConsultationForm";
        }
        return "addConsultationForm";
    }

    @PostMapping("/createConsultation")
    public ModelAndView createConsultation(@ModelAttribute ConsultationDto consultationDto) {
        consultationService.createConsultation(consultationDto);
        List<Consultation> consultationDtoList = consultationService.getAll();

        ModelAndView mav = new ModelAndView("cons_list");

        mav.addObject("consultationDtoList", consultationDtoList);

        return mav;
    }

}