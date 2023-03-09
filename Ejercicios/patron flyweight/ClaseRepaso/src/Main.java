public class Main {
    public static void main(String[] args) {

        Maquina m1 = new Maquina("Mercedes", 100);

        Auto a1 = new Auto("Pepito", 66);

        a1.chocar(a1);

        a1.mostrarMisDatos();

    }
}