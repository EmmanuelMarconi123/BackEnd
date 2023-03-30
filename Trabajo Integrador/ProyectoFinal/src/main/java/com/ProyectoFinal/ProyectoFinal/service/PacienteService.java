package com.ProyectoFinal.ProyectoFinal.service;

import com.ProyectoFinal.ProyectoFinal.persistence.entities.Paciente;
import com.ProyectoFinal.ProyectoFinal.persistence.entities.Turno;
import com.ProyectoFinal.ProyectoFinal.persistence.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepo;

    @Autowired
    ObjectMapper mapper;


    public Paciente agregarPaciente(Paciente p){ return pacienteRepo.save(p); }

    public List<Paciente> obtenerTodosPacientes(){
        return pacienteRepo.findAll();
    }

    public String eliminarPaciente (Integer id){
        if(pacienteRepo.findById(id).isPresent()){
            pacienteRepo.deleteById(id);
            return "Paciente con Id: " + id + " fue eliminado";

        }
        return "Paciente con Id: " + id + " no fue encontrado";
    }
    public Optional<Paciente> buscarPaciente (Integer id){
        if(pacienteRepo.findById(id) !=null){
            return pacienteRepo.findById(id);
        }else {
            return null;
        }
    }

    public Paciente actualizarPaciente(Paciente p){
        if(pacienteRepo.findById(p.getId())!= null){
            return pacienteRepo.save(p);
        }else {
            return null;
        }
    }

    public Set<Turno> getTurnosByPacienteId(Integer pacienteId) {
        Paciente paciente = pacienteRepo.findById(pacienteId).orElse(null);
        return paciente.getTurno();
    }



}
