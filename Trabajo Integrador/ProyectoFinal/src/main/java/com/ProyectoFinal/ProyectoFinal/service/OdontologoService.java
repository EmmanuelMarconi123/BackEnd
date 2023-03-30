package com.ProyectoFinal.ProyectoFinal.service;


import com.ProyectoFinal.ProyectoFinal.persistence.entities.Odontologo;
import com.ProyectoFinal.ProyectoFinal.persistence.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    OdontologoRepository  odontologoRepo;

    public Odontologo agregarOdontologo(Odontologo o){ return odontologoRepo.save(o); }

    public List<Odontologo> obtenerTodosOdontologos(){ return odontologoRepo.findAll(); }

    public String eliminarOdontologo (Integer id){

        if(odontologoRepo.findById(id) != null){
            odontologoRepo.deleteById(id);
            return "El odontologo con ID: " + id + " fue eliminado correctamente";
        }else {
            return "no pudimos eliminar el odontologo con el ID: " + id;
        }
    }

    public Optional<Odontologo> buscarOdontologo(Integer id) {
        if (odontologoRepo.findById(id) != null) {
            return odontologoRepo.findById(id);
        } else {
            return null;
        }
    }

    public Odontologo actualizarOdontologo (Odontologo o){

        if (odontologoRepo.findById(o.getId()) != null){
            return odontologoRepo.save(o);
        }else {
            return null;
        }

    }







}
