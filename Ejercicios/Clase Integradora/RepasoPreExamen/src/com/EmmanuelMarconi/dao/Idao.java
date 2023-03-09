package com.EmmanuelMarconi.dao;
import java.sql.SQLException;
import java.util.List;

public interface Idao<T> {

    public T registrar(T t);

    public T buscar(int id);

    public void eliminar(int id);

    public List<T> buscarTodos();

}
