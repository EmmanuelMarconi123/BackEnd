import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona( "emma", "marconi", 34079819, new Date(11, 5, 1),  "lklklklk");
        Registro registro= new RegistroVacunaProxy();
        registro.registrar(persona.datos());


    }
}