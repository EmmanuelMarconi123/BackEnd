public class Auto extends Maquina {

    private int cantidadDeCambio;
    private boolean chocado = false;

    public Auto(String nombre, int durabilidad) {
        super(nombre, durabilidad);

    }

    public boolean isChocado() {
        return chocado;
    }

    public void setChocado(boolean chocado) {
        this.chocado = chocado;
    }

    public int getCantidadDeCambio() {
        return cantidadDeCambio;
    }

    public void setCantidadDeCambio(int cantidadDeCambio) {
        this.cantidadDeCambio = cantidadDeCambio;
    }

    public void chocar(Auto autoAChocar){

        this.chocado = true;
        autoAChocar.chocado = true;

    }

    public void mostrarMisDatos(){
        System.out.println( this.getMarca() );
        System.out.println( this.getDurabilidad() );
        System.out.println( this.isChocado() );
        System.out.println(this.cantidadDeCambio);

    }

}
