package com.ProyectoFinal.ProyectoFinal.controller;


import com.ProyectoFinal.ProyectoFinal.persistence.entities.Odontologo;
import com.ProyectoFinal.ProyectoFinal.persistence.entities.Paciente;
import com.ProyectoFinal.ProyectoFinal.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService odontologoServ;

    @PostMapping("/agregar")
    public Odontologo agregarOdontologo(@RequestBody Odontologo o){
        return odontologoServ.agregarOdontologo(o);
    }

    @GetMapping("/todos")
    public List<Odontologo> consultarTodosLosOdontologos(){
       return odontologoServ.obtenerTodosOdontologos();
    }

    @GetMapping("/{id}")
    public Optional<Odontologo> traerunOdontologo(@PathVariable Integer id){
        if(odontologoServ.buscarOdontologo(id) !=null){
            return odontologoServ.buscarOdontologo(id);
        }
        return null;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Integer id) {

        if (odontologoServ.buscarOdontologo(id) != null) {
            odontologoServ.eliminarOdontologo(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Odontologo eliminado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
   }

    @PutMapping("/actualizar/{id}")
    public String actualizar (@RequestBody Odontologo odontologoActualizado, @PathVariable Integer id){

        Optional<Odontologo> odontologo = odontologoServ.buscarOdontologo(id);

        if( odontologo.isPresent()){
            odontologo.get().setNombre(odontologoActualizado.getNombre());
            odontologo.get().setApellido(odontologoActualizado.getApellido());
            odontologo.get().setMatricula(odontologoActualizado.getMatricula());
            odontologoServ.actualizarOdontologo(odontologo.get());

            return "El odontologo con ID: " + odontologo.get().getId() + " fue actualizado correctamente";
        }else {
            return "no encontramos el odontologo con ese ID para actualizar";
        }
    }


}
