package com.EmmanuelMarconi.Dao.Impl;

import com.EmmanuelMarconi.Dao.IDao;
import com.EmmanuelMarconi.Model.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

//    private static final Logger logger = Logger.getLogger(String.valueOf(OdontologoDaoH2.class));

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO odontologos(matricula,nombre,apellido) VALUES(?,?,?)");

            preparedStatement.setInt(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            preparedStatement.executeUpdate();

            preparedStatement.close();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

//        logger.info("logueamos a un odontólogo nuevo");

        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

//            logger.info("Vamos a listar a todos los odontólogos ya registrados");

            String sql = "SELECT * FROM odontologos";
            Statement stmt = connection.createStatement();


            ResultSet result = stmt.executeQuery(sql);

            while (result.next()){

                String nombre = result.getString("nombre");
                int matricula =result.getInt("matricula");
                String apellido = result.getString("apellido");

                Odontologo odontologo = new Odontologo(matricula,nombre,apellido);
                odontologos.add(odontologo);

//                logger.info("listado: " + result.getInt(1) + result.getString(2) + result.getString(3));

            }


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }
        return odontologos;
    }
}
