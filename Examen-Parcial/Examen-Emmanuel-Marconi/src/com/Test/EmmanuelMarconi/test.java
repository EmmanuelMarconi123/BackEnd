package com.Test.EmmanuelMarconi;
import com.EmmanuelMarconi.Dao.Impl.OdontologoDaoH2;
import com.EmmanuelMarconi.Model.Odontologo;
import com.EmmanuelMarconi.Service.OdontologoService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import java.util.List;
import org.apache.log4j.Logger;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)

public class test {

    private static final Logger logger = Logger.getLogger(String.valueOf(test.class));

    private static OdontologoService odontologoService = new OdontologoService( new OdontologoDaoH2());

    @BeforeClass
    public static void creandoYGuardandoOdontologos(){

        Odontologo odontologo1 = new Odontologo(123,"Pepito", "Perez");
        Odontologo odontologo2 = new Odontologo(124,"Pablito", "Ramirez");
        Odontologo odontologo3 = new Odontologo(125,"Fulanito", "Gonzalez");
        Odontologo odontologo4 = new Odontologo(126,"Josecito", "Roberso");


        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);
        odontologoService.guardar(odontologo3);
        odontologoService.guardar(odontologo4);

        logger.info("probando el loguer aca");

    }

    @Test
    public void listando(){

        List<Odontologo> listOdontologos = odontologoService.buscarTodos();
        Assert.assertTrue(!listOdontologos.isEmpty());
        Assert.assertTrue(listOdontologos.size() > 0);
        System.out.println(listOdontologos);

    }



}
