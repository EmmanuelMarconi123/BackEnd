import java.util.ArrayList;

public class Empleado extends Vendedor{

    public Empleado (String nombre, int aniosAntiguedad){
        super.nombre=nombre;
        super.PUNTOS_POR_VENTA=5;
        this.aniosAntiguedad=aniosAntiguedad;
    }

    private int aniosAntiguedad;
    private ArrayList<Vendedor> afiliados=new ArrayList<>();

    @Override
    public int calcularPuntos() {
        return (this.afiliados.size()*10) + (this.aniosAntiguedad*5) + (super.ventas * PUNTOS_POR_VENTA);
    }

    public void addAfiliado(Vendedor afiliado){
        this.afiliados.add(afiliado);
    }


}
