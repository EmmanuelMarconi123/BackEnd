public class Main {
    public static void main(String[] args) {
        /*Mofidicar el main para testear la logica con el metodo templeate */
        Empleado emp1 = new Empleado("Juan (empleado)", 2);
        emp1.vender(2);
        Empleado emp2 = new Empleado("Maria (Empleada)", 1);
        emp2.vender(1);

        Vendedor afi1 = new Afiliado("Jose (Afiliado)");
        afi1.vender(4);
        Vendedor afi2 = new Afiliado("Alicia (Afiliada)");
        afi2.vender(1);
        Vendedor afi3 = new Afiliado("Josefina (Afiliada");

        emp1.addAfiliado(afi1);

        System.out.println(emp1.getNombreCategoria());
        System.out.println(emp2.getNombreCategoria());
        System.out.println(afi1.getNombreCategoria());
    }
}
