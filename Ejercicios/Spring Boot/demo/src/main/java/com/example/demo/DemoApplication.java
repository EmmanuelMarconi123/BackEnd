package com.example.demo;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoApplication {

    @GetMapping("/index")

    public String bienvenido(Model model){

        model.addAttribute("nombre", "juan");
        model.addAttribute("apellido", "Perez");
        return "index";

    }

}
