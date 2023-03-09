public class ValidarLote  extends CompruebaCalidad{

    AnalistaDeCalidad cadenaDeEvaluación = new AnalistaDeCalidad();

    @Override
    public void validarCalidadDelProducto(Articulo articulo) {

        if (articulo.getLote() > 1000 && articulo.getLote() < 2000){
            System.out.println("tu producto esta rechazado por no contar con el lote correcto");
        }
        else (this.cadenaDeEvaluación != null){

        }

    }
}
