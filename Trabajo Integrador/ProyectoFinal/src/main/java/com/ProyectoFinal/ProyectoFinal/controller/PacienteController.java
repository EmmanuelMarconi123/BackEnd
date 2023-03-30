package com.ProyectoFinal.ProyectoFinal.controller;

import com.ProyectoFinal.ProyectoFinal.persistence.entities.Paciente;
import com.ProyectoFinal.ProyectoFinal.persistence.entities.Turno;
import com.ProyectoFinal.ProyectoFinal.service.PacienteService;
import com.ProyectoFinal.ProyectoFinal.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteServ;

    @Autowired
    TurnoService turnoServ;


    @PostMapping("/agregar")
    public ResponseEntity<String> agregarPaciente(@RequestBody Paciente p) {
        ResponseEntity<String> respuesta = null;

        if (pacienteServ.agregarPaciente(p) != null) {
            respuesta = ResponseEntity.ok("El Paciente fue creado con éxito");
        } else {
            respuesta = ResponseEntity.internalServerError().body("parece ue surgio un error");
        }
        return respuesta;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Paciente>> consultarTodosLosPacientes() {
        return ResponseEntity.ok(pacienteServ.obtenerTodosPacientes());
    }

    @GetMapping("/{id}")
    public Optional<Paciente> buscarUnpaciente(@PathVariable Integer id) {
        Optional<Paciente> paciente = pacienteServ.buscarPaciente(id);

        return paciente;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (pacienteServ.buscarPaciente(id) != null) {
            pacienteServ.eliminarPaciente(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }


    @PutMapping("/actualizar/{id}")
    public String actualizar(@RequestBody Paciente pacienteActualizado, @PathVariable Integer id) {

        Optional<Paciente> paciente = pacienteServ.buscarPaciente(id);

        if (paciente.isPresent()) {
            paciente.get().setDNI(pacienteActualizado.getDNI());
            paciente.get().setNombre(pacienteActualizado.getNombre());
            paciente.get().setApellido(pacienteActualizado.getApellido());
            paciente.get().setFechaDeIngreso(pacienteActualizado.getFechaDeIngreso());
            paciente.get().setDomicilio(pacienteActualizado.getDomicilio());
            pacienteServ.actualizarPaciente(paciente.get());
            return "El paciente con ID: " + paciente.get().getId() + " fue actualizado correctamente";
        } else {
            return "no encontramos el pasiente con ese ID para actualizar" + id;
        }
    }

    @GetMapping("/turnosDelPasiente/{id}")
    public ResponseEntity<Set<Turno>> turnosDelPasiente(@PathVariable Integer id){

        Set<Turno> turnos = pacienteServ.getTurnosByPacienteId(id);

        return ResponseEntity.ok(turnos);
    }




}











