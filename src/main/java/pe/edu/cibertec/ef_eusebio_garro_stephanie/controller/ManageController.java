package pe.edu.cibertec.ef_eusebio_garro_stephanie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.ef_eusebio_garro_stephanie.dto.CarDto;
import pe.edu.cibertec.ef_eusebio_garro_stephanie.service.ManageService;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    ManageService manageService;

    @GetMapping("/start")
    public String start(Model model) {
        try {
            List<CarDto> cars = manageService.getAllCars();
            model.addAttribute("cars", cars);
            model.addAttribute("error", "");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "error al cargar datos");
        }
        return "manage";
    }
}
