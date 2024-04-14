package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Stack;

import static edu.upc.dsa.DronesManagerImpl.logger;

public class DronesManagerTest {
    DronesManager tm;

    @Before
    public void addDronesPilotos() {
        tm = new DronesManagerImpl();

        tm.addDron("852","Dron8888", "Cisco", "4000", 7);
        tm.addDron("oodDD","Fast6400", "Huawei", "6400", 2);
        tm.addDron("TSGS5455", "Ultra8000", "Apple", "8000", 6);

        tm.addPiloto("Paco", "Dann", 8);
        tm.addPiloto("Carlos", "Fonsi",3);
        tm.addPiloto("Juan", "Antonio",4);
    }

    @Test
    public void testPerFlightHours() {
        List<Dron> dronesFlightHours = this.tm.dronsbyhoras();
        logger.info(dronesFlightHours);

        List<Piloto> pilotosFlightHours = this.tm.pilotobyhoras();
        logger.info(pilotosFlightHours);
    }

    @Test
    public void testGuardarAlmacen() {
        Dron t = this.tm.getDrone(this.tm.findAll().get(0).getId());
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" saved ");

        this.tm.addAlmacen(this.tm.findAll().get(0).getId());
    }

    @Test
    public void testReparacionEnAlmacen() {
        testGuardarAlmacen();
        logger.info("deleted closest Dron");
        this.tm.deleteAlmacen();
    }

    @Test
    public void testAlmacen() {
        testGuardarAlmacen();
        Stack<Dron> a = this.tm.getAlmacen();
        logger.info(a+"Almacen");
    }

}