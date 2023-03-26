package com.ProyectoFinal.ProyectoFinal.controller;

import com.ProyectoFinal.ProyectoFinal.persistence.entities.Paciente;
import com.ProyectoFinal.ProyectoFinal.persistence.repository.PacienteRepository;
import com.ProyectoFinal.ProyectoFinal.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteRepo;

    @PostMapping("/alta")
    public ResponseEntity<String> alta (@RequestBody Paciente p){
        ResponseEntity<String> respuesta = null;

        if(pacienteRepo.alta(p) != null){
            respuesta = ResponseEntity.ok("El Paciente fue creado con éxito");
        }else {
            respuesta = ResponseEntity.internalServerError().body("parece ue surgio un error");
        }
        return respuesta;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Paciente>> consultarTodos(){
        return ResponseEntity.ok(pacienteRepo.obtenerTodos());
    }





}
