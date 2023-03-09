public class Afiliado extends Vendedor{

    public Afiliado(String nombre) {
        super.nombre= nombre;
        super.PUNTOS_POR_VENTAS=15;
    }

    @Override
    public int calcularPuntos() {
        return this.ventas*15;
    }
}
