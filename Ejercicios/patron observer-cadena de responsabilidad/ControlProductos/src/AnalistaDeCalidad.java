public class AnalistaDeCalidad {

    CompruebaCalidad inicial;

    public void evaluandoCalidad(){

        this.inicial = new ValidarLote();
        new ValidarPeso().setInicioProceso(inicial);
        new ValidarEnvase().setInicioProceso(inicial);

    }

}
