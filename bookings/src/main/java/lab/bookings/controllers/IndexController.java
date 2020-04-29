package lab.bookings.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class IndexController {
    @RequestMapping("/controller")
    public String index(@RequestParam(required = false) String name, Model model) {
        if (Objects.isNull(name) || name.equals("")) {
            name="Anonymous";
        }
        model.addAttribute("name",name);
        return "index";
    }
}
