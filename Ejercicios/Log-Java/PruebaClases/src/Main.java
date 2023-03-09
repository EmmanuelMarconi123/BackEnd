import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String animal1 = "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (1, 'Pancho', 'Perro')";

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " TIPO varchar(100) NOT NULL "
            + " )";

    public static Connection verDatos() throws SQLException {
        try {
            Class.forName("org.h2.Driver").newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection("jdbc:h2:~/test", "sa","");

    }

    public static void main(String[] args) {

        Connection conec1 = null;

        try {
            conec1 = verDatos();
            Statement st1 = conec1.createStatement();
            st1.execute(animal1);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

}