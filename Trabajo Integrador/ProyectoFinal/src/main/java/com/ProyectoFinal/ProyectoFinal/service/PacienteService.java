package com.ProyectoFinal.ProyectoFinal.service;

import com.ProyectoFinal.ProyectoFinal.persistence.entities.Paciente;
import com.ProyectoFinal.ProyectoFinal.persistence.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepo;

    public String alta(Paciente p){
        if(pacienteRepo.save(p) != null){
            return "OK";
        }else{
            return null;
        }
    }

    public List<Paciente> obtenerTodos(){
        return pacienteRepo.findAll();
    }

    public void eliminar





}
