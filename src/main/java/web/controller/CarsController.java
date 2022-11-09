package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.Service;


@Controller
public class CarsController {

/* не сосвсем  корректно  условие - из него  четко не  следует,
что при  запросе 1 машины  мы  должны  вывести только  одну.Соответственно  реализовал
с  ошибкой.
/*
/*   @GetMapping(value = "/cars")
    public String showCars(@RequestParam(defaultValue = "5") int count, Model model) {

        if (count == 1) {
            return "invalid request";
        } else {
            Service service = new Service();
            model.addAttribute("count", service.getCars(count));
            return "cars";
        }
    }

 */

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(defaultValue = "5") int count, Model model) {


        Service service = new Service();
        model.addAttribute("count", service.getCars(count));
        return "cars";
    }
}


