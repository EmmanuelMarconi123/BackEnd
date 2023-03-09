public class Maquina {
    
    private String marca;
    private int durabilidad;

    public Maquina(String marca, int durabilidad) {
        this.marca = marca;
        this.durabilidad = durabilidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setNombre(String nombre) {
        this.marca = nombre;
    }

    public int getDurabilidad() {
        return durabilidad;
    }

    public void setDurabilidad(int durabilidad) {
        this.durabilidad = durabilidad;
    }
}
