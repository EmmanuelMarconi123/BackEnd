public class MenuInfantil extends ArmadoMenu{

    private double cantidadDeJuguetes;
    private double precioAdicional = 3;

    public MenuInfantil(double cantidadDeJuguetes) {
        this.cantidadDeJuguetes = cantidadDeJuguetes;
    }

    public double getCantidadDeJuguetes() {
        return cantidadDeJuguetes;
    }



    @Override
    protected void ingredientes(){
        System.out.println("los ingredientes son los mismos que el clasico pero incluye juguete");
    }


    @Override
    protected double adicionales() {
        double montoPagar = cantidadDeJuguetes * precioAdicional;
        return montoPagar;
    }

}
