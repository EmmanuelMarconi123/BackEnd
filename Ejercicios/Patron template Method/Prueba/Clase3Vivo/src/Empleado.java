import java.util.ArrayList;

public class Empleado extends Vendedor{

    public Empleado(String nombre, int aniosDeAntiguedad) {
        this.aniosDeAntiguedad = aniosDeAntiguedad;
        super.PUNTOS_POR_VENTAS=5;
        super.nombre=nombre;
    }

    private ArrayList<Vendedor> afiliados= new ArrayList<>();
    private int aniosDeAntiguedad;

    @Override
    public int calcularPuntos() {
        int cantidadDeAfiliados=this.afiliados.size()*10;
        int añosDeAntiguedad = this.aniosDeAntiguedad*5;
        int cantidadDeVentas = super.ventas*PUNTOS_POR_VENTAS;

        return (cantidadDeAfiliados+añosDeAntiguedad+cantidadDeVentas);
    }

    public void addAfiliado(Vendedor afiliado){
        this.afiliados.add(afiliado);
    }
}
