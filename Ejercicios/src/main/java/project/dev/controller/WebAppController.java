package project.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class WebAppController {

	@RequestMapping("/")
    public String getHome() {
        return "index";
    }
    
    @RequestMapping("/Goles")
    public String getGoles() {
        return "Goles";
    }
}
