package com.ejemploClases.Paciente;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class PacienteControler {
    @GetMapping("/index")
    public String nombres(Model model){

        model.addAttribute("nombre", "juan");
        model.addAttribute("apellido", "perez");

        return "index";

    }

}
