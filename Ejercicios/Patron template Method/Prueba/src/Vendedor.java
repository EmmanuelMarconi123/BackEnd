public abstract class Vendedor {
    protected String nombre;
    protected int ventas = 0;
    protected int PUNTOS_POR_VENTA;

    public void vender(int cantVentas) {
        this.ventas += cantVentas;
    }

    public abstract int calcularPuntos();

    public String getNombreCategoria() {
        int puntosVendedor = calcularPuntos();

        if (puntosVendedor < 20) {
            return "novato";
        } else if (puntosVendedor < 31) {
            return "aprendiz";
        } else if (puntosVendedor < 41) {
            return "bueno";
        } else {
            return "maestro";

        }
    }
}


