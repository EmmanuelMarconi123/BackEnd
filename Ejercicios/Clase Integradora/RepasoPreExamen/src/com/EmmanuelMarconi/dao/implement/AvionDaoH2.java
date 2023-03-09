package com.EmmanuelMarconi.dao.implement;

import com.EmmanuelMarconi.dao.Idao;
import com.EmmanuelMarconi.model.Avion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AvionDaoH2 implements Idao<Avion> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";

    private final static String DB_URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

//    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS avion; CREATE TABLE BaseDatosAvion "
//            + "("
//            + " ID INT PRIMARY KEY AUTO_INCREMENT,"
//            + " MARCA varchar(255) NOT NULL, "
//            + " MODELO varchar(255) NOT NULL, "
//            + " MATRICULA varchar(255) NOT NULL, "
//            + " FECHAENTRADA varchar(100) NOT NULL "
//            + " )";

     private static final Logger logger = Logger.getLogger(String.valueOf(AvionDaoH2.class));


    @Override
    public Avion registrar(Avion avion){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
//        Statement statement = connection.createStatement();
        logger.info("Arrancamos con el primer logg de registrar");

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO avion(marca,modelo,matricula,fechaEntrada) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, avion.getMarca());
            preparedStatement.setString(2, avion.getModelo());
            preparedStatement.setString(3, avion.getMatricula());
            preparedStatement.setString(4, avion.getFechaEntrada());

            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();

            if (keys.next())
                avion.setId(keys.getInt(1));

            preparedStatement.close();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return avion;

    }
    @Override
    public Avion buscar(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Avion avion = null;

        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT id,marca,modelo,matricula,fechaEntrada FROM avion where id = ?");
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {

                int idAvion = result.getInt("id");
                String marca = result.getString("marca");
                String modelo = result.getString("modelo");
                String matricula = result.getString("matricula");
                String fechaEntrada = result.getString("fechaEntrada");

                avion = new Avion(marca, modelo, matricula, fechaEntrada);

            }
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return avion;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM avion WHERE id = ?");

            preparedStatement.setInt(1, id);


            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }



    @Override
    public List<Avion> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Avion> aviones = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM Avion");
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int idAvion = result.getInt("id");
                String marca = result.getString("marca");
                String modelo = result.getString("modelo");
                String matricula = result.getString("matricula");
                String fechaEntrada = result.getString("fechaEntrada");

                Avion avion = new Avion(marca, modelo, matricula, fechaEntrada);
                aviones.add(avion);

            }

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return aviones;
    }
}


