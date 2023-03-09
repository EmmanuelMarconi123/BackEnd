package com.EmmanuelMarconi.service;

import com.EmmanuelMarconi.dao.Idao;
import com.EmmanuelMarconi.model.Avion;

import java.sql.SQLException;
import java.util.List;

public class AvionService {

    private Idao<Avion> aviones;

    public AvionService(Idao<Avion> aviones) {
        this.aviones = aviones;
    }

    public Avion registrar(Avion a){
        return aviones.registrar(a);
    }

    public Avion buscar(int id) {
        return aviones.buscar(id);
    }

    public void eliminar(int id) {
        aviones.eliminar(id);
    }

    public List<Avion> buscarTodos() {
        return aviones.buscarTodos();
    }
}
