package projectuas.bookingticketmovie.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projectuas.bookingticketmovie.data.entity.Auditorium;
import projectuas.bookingticketmovie.service.AuditoriumService;

@Controller
public class TestAuditoriumControllerCRUD {

    private AuditoriumService auditoriumService;

    @Autowired
    public TestAuditoriumControllerCRUD(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    @GetMapping("/form-auditorium")
    public String showAuditoriumForm(Model model) {
        Auditorium auditorium = new Auditorium();
        model.addAttribute("auditoriums", auditorium);
        return "form-auditorium";
    }

    @PostMapping("/form-auditorium/save")
    public String addAuditorium(@Valid @ModelAttribute("auditoriums") Auditorium auditorium,
                                BindingResult result,
                                Model model) {
        auditoriumService.pushAuditorium(auditorium);
        return "redirect:/auditorium";
    }
}
