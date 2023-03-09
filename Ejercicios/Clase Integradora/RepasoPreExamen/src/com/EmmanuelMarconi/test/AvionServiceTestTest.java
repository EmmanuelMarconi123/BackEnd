package com.EmmanuelMarconi.test;
import com.EmmanuelMarconi.dao.implement.AvionDaoH2;
import com.EmmanuelMarconi.model.Avion;
import com.EmmanuelMarconi.service.AvionService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)

public class AvionServiceTestTest {



    private static AvionService avionService = new AvionService( new AvionDaoH2());

    @BeforeClass
    public static void generadorDeAviones(){

        Avion avion1 = avionService.registrar(new Avion("Boing", "2022", "kft-555", "22-05-2022"));
        Avion avion2 = avionService.registrar(new Avion("Zulu", "2023", "kft-000", "20-05-2020"));

    }

    @Test
    public void buscarTodosAviones() {

        List<Avion> aviones = avionService.buscarTodos();
        Assert.assertTrue(!aviones.isEmpty());
        Assert.assertTrue(aviones.size() > 0);
        System.out.println(aviones);
    }
//
//    @Test
//    public void eliminarAvionTest() {
//
//        avionService.eliminar(2);
//        Assert.assertTrue(avionService.buscar(1) == null);
//        System.out.println(avionService);
//
//    }
//

}