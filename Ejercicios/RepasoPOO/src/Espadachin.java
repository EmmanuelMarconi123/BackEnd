public class Espadachin extends Guerrero{


    public Espadachin(String nombre, int energia, int movilidad, boolean vivo, Espada espadita) {
        super(nombre, energia);
        this.movilidad = movilidad;
        this.vivo = vivo;
        this.espadita = espadita;
    }

    private int movilidad;
    private boolean vivo;

    Espada espadita;

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public int getMovilidad() {
        return movilidad;
    }

    public void setMovilidad(int movilidad) {
        this.movilidad = movilidad;
    }

    public Espada getEspadita() {
        return espadita;
    }

    public void setEspadita(Espada espadita) {
        this.espadita = espadita;
    }
}
