import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Guerrero ninja1 = new Guerrero( "jose",100 );

        ninja1.setEnergia(100);
        ninja1.setNombre("Robert");

        System.out.println(ninja1);

        Espada es1 = new Espada("Acero", 100);

        ArrayList<Espadachin> malon = new ArrayList<Espadachin>(100);

        Random random = new Random();

        for(int i=0; i<100;i++){
            malon.add( new Espadachin("pepe "+ (i + 1),100, 10, true, new Espada("acero", random.nextInt(100-50))));
            //malon.get(i).setNombre("juan "+(i+1));
            /*malon.get(i).setEspadita(new Espada("Acero", random.nextInt(100-50)));*/
        }

        for (int i = 0; i < malon.size(); i++) {
            System.out.println(malon.get(i).getNombre());
            System.out.println(malon.get(i).getEspadita().getFuerza());
        }



    }
}