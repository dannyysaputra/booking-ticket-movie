package projectuas.bookingticketmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import projectuas.bookingticketmovie.data.entity.Auditorium;
import projectuas.bookingticketmovie.service.AuditoriumService;

import java.util.List;

@Controller
public class AuditoriumController {
    private AuditoriumService auditoriumService;

    @Autowired
    public AuditoriumController(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    @GetMapping("/auditorium")
    public String getAllAuditorium(Model model) {

        model.addAttribute("auditoriums", auditoriumService.getAllAuditoriums());
        return "auditorium";
    }
}
