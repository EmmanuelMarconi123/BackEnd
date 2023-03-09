public  abstract class CompruebaCalidad {

    protected CompruebaCalidad inicioProceso;

    public void setInicioProceso(CompruebaCalidad inicioProceso) {
        this.inicioProceso = inicioProceso;
    }

    public abstract void validarCalidadDelProducto(Articulo articulo);



}
