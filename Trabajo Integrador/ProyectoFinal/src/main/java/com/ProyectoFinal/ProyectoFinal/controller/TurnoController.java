package com.ProyectoFinal.ProyectoFinal.controller;

import com.ProyectoFinal.ProyectoFinal.persistence.entities.Turno;
import com.ProyectoFinal.ProyectoFinal.service.OdontologoService;
import com.ProyectoFinal.ProyectoFinal.service.PacienteService;
import com.ProyectoFinal.ProyectoFinal.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    TurnoService turnoServ;

    @Autowired
    PacienteService pacienteServ;

    @Autowired
    OdontologoService odontologoServ;


    @PostMapping("/agregar")
    public String agregarTurno(@RequestBody Turno turno) {

        if (turno != null) {
            turnoServ.agregarTurno(turno);
            return "turno guardado con exito";
        }
        return "el turno no fue cargado correctamente";
    }

    @GetMapping("/todos")
    public List<Turno> traerTodosLosTurnos() {
        return turnoServ.obtenerTodosTurnos();
    }

    @GetMapping("/{id}")
    public Optional<Turno> buscarunTurno(@PathVariable Integer id) {
        Optional<Turno> turno = turnoServ.buscarTurno(id);
        return turno;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (turnoServ.buscarTurno(id) != null) {
            turnoServ.eliminarTurno(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping("/actualizar/{id}")
    public String actualizar(@RequestBody Turno turnoActualizado, @PathVariable Integer id) {

        Optional<Turno> turno = turnoServ.buscarTurno(id);

        if (turno.isPresent()) {
            turno.get().setFechaTurno(turnoActualizado.getFechaTurno());
            turno.get().setOdontologo(turnoActualizado.getOdontologo());
            turno.get().setPaciente(turnoActualizado.getPaciente());
            turnoServ.actualizarTurno(turno.get());
            return "El turno con ID: " + turno.get().getId() + " fue actualizado correctamente";
        } else {
            return "no encontramos el turno con ese ID para actualizar" + id;
        }
    }

}
