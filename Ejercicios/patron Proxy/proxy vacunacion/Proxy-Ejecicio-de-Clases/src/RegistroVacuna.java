public class RegistroVacuna implements Registro{

    @Override
    public void registrar(Object[] datos) {
        System.out.println("se ha registrado al usuario " + datos[0] + "en la fecha " + datos[1].toString() + "esta vacuna"  );
    }
}
