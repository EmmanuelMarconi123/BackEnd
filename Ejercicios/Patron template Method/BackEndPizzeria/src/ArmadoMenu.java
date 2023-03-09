import java.sql.SQLOutput;

public abstract class ArmadoMenu {

    public void armarElMenu(){
        prepararMenuClasico();
        prepararMenuInfantil();
        prepararMenuVegetariano();
        ingredientes();
        adicionales();
    }

    protected abstract void ingredientes();
    protected abstract double adicionales();

    private void prepararMenuClasico(){
        System.out.println("Preparando el Menu clasico que incluye los siguientes ingredientes: ");
    }

    private void prepararMenuInfantil(){
        System.out.println("Preparando el Menu infantil que incluye los siguientes ingredientes: ");
    }

    private void prepararMenuVegetariano(){
        System.out.println("Preparando el Menu Vegetariano que incluye los siguientes ingredientes: ");
    }

}
