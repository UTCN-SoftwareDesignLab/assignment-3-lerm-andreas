package bookstore.presentation;

import bookstore.business.dto.BookDto;
import bookstore.business.dto.UserDto1;
import bookstore.business.service.BookService;
import bookstore.business.service.UserService1;
import bookstore.data.entity.Book;
import bookstore.data.entity.User1;
import bookstore.report.CSVReport;
import bookstore.report.PDFReport;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
public class AdministratorController {

    @Autowired
    BookService bookService;

    @Autowired
    UserService1 userService;

    @Autowired
    public  AdministratorController(final BookService bookService, final UserService1 userService){
        this.bookService = bookService;
        this.userService=userService;
    }


    @GetMapping("/administrator")
    public String getAdministratorPage(Model model){
        return "adminPage";
    }

    @PostMapping("/administrator")
    public String showAdministratorPage(Model model){
        return "adminPage";
    }


    @GetMapping("/createUserForm")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserDto1());
        return "addUserForm";
    }

    @PostMapping("/createUserForm")
    public String createUserFormGet(@ModelAttribute("user") @Valid UserDto1 userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addUserForm";
        }

        return "addUserForm";
    }

    @PostMapping("/createUser")
    public ModelAndView createUser(@ModelAttribute UserDto1 userDto1) {
        userService.createUser(userDto1);
        List<User1> userDtoList = userService.getAll();

        ModelAndView mav = new ModelAndView("users1_list");

        mav.addObject("userDtoList1", userDtoList);

        return mav;
    }

    @GetMapping("/deleteUserForm")
    public String deleteUserFormGet(Model model) {
        model.addAttribute("user", new UserDto1());
        return "deleteUserForm";
    }

    @PostMapping("deleteUserForm")
    public String deleteUserForm(@ModelAttribute("user") @Valid UserDto1 userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "deleteUserForm";
        }
        return "deleteUserForm";
    }

    @PostMapping("/deleteUser")
    public ModelAndView deleteUser(@ModelAttribute UserDto1 userDto) {
        userService.deleteUser(userDto);
        List<User1> userDtoList = userService.getAll();

        ModelAndView modelAndView = new ModelAndView("users1_list");

        modelAndView.addObject("userDtoList1", userDtoList);
        return modelAndView;
    }


    @GetMapping("/updateUserForm")
    public String updateUserFormGet(Model model) {
        model.addAttribute("user", new UserDto1());

        return "updateUserForm";
    }


    @PostMapping("/updateUserForm")
    public String updateUserForm(@ModelAttribute("user") @Valid UserDto1 userDto1, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUserForm";
        }
        return "updateUserForm";
    }


    @PostMapping("/updateUser")
    public ModelAndView updateUser(@ModelAttribute UserDto1 userDto1) {
        userService.updateUser(userDto1);

        List<User1> userDtoList = userService.getAll();

        ModelAndView modelAndView = new ModelAndView("users1_list");

        modelAndView.addObject("userDtoList1", userDtoList);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model,HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        if(session.getAttribute("errorMessage")!=null)
        {
            model.addAttribute("incorrect",(String)session.getAttribute("errorMessage"));
        }
        return "login";
    }

}

