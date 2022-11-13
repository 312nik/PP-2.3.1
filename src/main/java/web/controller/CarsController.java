package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.ServiceImp;


@Controller
public class CarsController {


 @GetMapping(value = "/cars")
    public String showCars(@RequestParam(defaultValue = "5") int count, Model model) {

        if ( count < 2) {
            return "invalid request";
        } else {
            ServiceImp service = new ServiceImp();
            model.addAttribute("count", service.getCars(count));
            return "cars";
        }
    }



}


