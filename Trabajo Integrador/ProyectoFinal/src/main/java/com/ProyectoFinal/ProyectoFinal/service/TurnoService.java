package com.ProyectoFinal.ProyectoFinal.service;

import com.ProyectoFinal.ProyectoFinal.persistence.entities.Paciente;
import com.ProyectoFinal.ProyectoFinal.persistence.entities.Turno;
import com.ProyectoFinal.ProyectoFinal.persistence.repository.OdontologoRepository;
import com.ProyectoFinal.ProyectoFinal.persistence.repository.PacienteRepository;
import com.ProyectoFinal.ProyectoFinal.persistence.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    TurnoRepository turnoRepo;

    public Turno agregarTurno(Turno t){
        return turnoRepo.save(t);
    }

    public List<Turno> obtenerTodosTurnos(){ return turnoRepo.findAll(); }

    public String eliminarTurno (Integer id){
        if(turnoRepo.findById(id).isPresent()){
            turnoRepo.deleteById(id);
            return "Turno con Id: " + id + " fue eliminado";

        }
        return "Turno con Id: " + id + " no fue encontrado";
    }

    public Optional<Turno> buscarTurno (Integer id){
        if(turnoRepo.findById(id) !=null){
            return turnoRepo.findById(id);
        }else {
            return null;
        }
    }

    public Turno actualizarTurno(Turno t){
        if(turnoRepo.findById(t.getId())!= null){
            return turnoRepo.save(t);
        }else {
            return null;
        }
    }


}
