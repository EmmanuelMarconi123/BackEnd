import java.util.Date;

public class RegistroVacunaProxy implements Registro {

    @Override
    public void registrar(Object[] datos) {
        if(comprobarFecha((Date) datos[1])){ // aqui hice el casteo del dato de tipo fecha
            RegistroVacuna registroVacuna = new RegistroVacuna();
            registroVacuna.registrar(datos);
        };
    }

    public boolean comprobarFecha ( Date fecha){
        return fecha.before(new Date());
    }

}
