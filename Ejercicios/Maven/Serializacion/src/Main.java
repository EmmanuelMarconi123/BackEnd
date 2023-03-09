import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contacto> contactos = new ArrayList<>();

        Contacto c1 = new Contacto("juan", "juan@mail.com", "5555555");
        Contacto c2 = new Contacto("pedro", "pedro@mail.com", "66666666666");
        Contacto c3 = new Contacto("pepito", "pepito@mail.com", "777777777");

        contactos.add(c1);
        contactos.add(c2);
        contactos.add(c3);
        contactos.add(new Contacto("raro", "raro@gmail.com", "88888888"));

        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream dos = new ObjectOutputStream(fo);

            dos.writeObject(contactos);


        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        FileInputStream fi =null;

        List<Contacto> contactos2= null;

        try{
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);

            contactos2= (ArrayList) ois.readObject();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        for (Contacto contacto: contactos2){
            System.out.println("El nombre del contacto es: " + contacto.getNombre() + " " + contacto.getMail());
        }



    }
}