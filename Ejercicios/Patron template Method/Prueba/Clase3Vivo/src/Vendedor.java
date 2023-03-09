public abstract class Vendedor {

    protected String nombre;
    protected int ventas = 0;
    protected int PUNTOS_POR_VENTAS;

    public void vender(int cantidadVentas) {
        this.ventas += cantidadVentas;
    }

    public abstract int calcularPuntos();


    public String getNombreCategoria() {
        int puntosVendedor = calcularPuntos();
        if (puntosVendedor < 20) {
            return "Es novato";
        } else if (puntosVendedor <= 30) {
            return "Es aprendiz";
        } else if (puntosVendedor <= 40) {
            return "Es bueno";
        } else {
            return "Es maestro";
        }
    }

}
