import java.util.Date;

public class Persona {
    private String nombre;
    private String apellido;
    private int DNI;
    private Date fecha;
    private String nombreDeLaVacuna;

    public Persona(String nombre, String apellido, int DNI, Date fecha, String nombreDeLaVacuna) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.fecha = fecha;
        this.nombreDeLaVacuna = nombreDeLaVacuna;
    }

    public Date getFecha() {
        return fecha;
    }

    public Object[] datos(){
        Object[] informacion;
        informacion= new Object[2];
        informacion[0]=DNI;
        informacion[1]=fecha;
        return informacion;
    }



}
