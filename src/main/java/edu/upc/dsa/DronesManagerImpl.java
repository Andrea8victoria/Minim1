package edu.upc.dsa;

import edu.upc.dsa.models.Dron;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.PlanVuelo;
import org.apache.log4j.Logger;

public class DronesManagerImpl implements DronesManager {
    private static DronesManager instance;
    protected List<Dron> drons;
    private ArrayList<Piloto> listaPilotos;
    private ArrayList<PlanVuelo> planesVuelos;
    final static Logger logger = Logger.getLogger(DronesManagerImpl.class);

    public DronesManagerImpl(){
        listaPilotos=new ArrayList<>();
        planesVuelos=new ArrayList<>();
        this.drons = new LinkedList<>();
    }


    public static DronesManager getInstance() {
        if (instance==null) instance = new DronesManagerImpl();
        return instance;
    }


    public ArrayList<Piloto> getListaPilotos() {
        return listaPilotos;
    }
    public int size() {
        int ret = this.drons.size();
        logger.info("size " + ret);

        return ret;
    }

    public Piloto addPiloto(Piloto p) {
        logger.info("new Piloto " + p);

        this.listaPilotos.add (p);
        logger.info("new Dron added");
        return p;
    }
    public Dron addDron(Dron t) {
        logger.info("new Dron " + t);

        this.drons.add (t);
        logger.info("new Dron added");
        return t;
    }

    /*
    public PlanVuelo addPlanVuelo(String idDron, String fecha, String tiempo, String origen, String destino, String piloto) {
        return this.addPlanVuelo(new PlanVuelo(idDron, fecha, tiempo, origen, destino, piloto));
    }

     */
    public Piloto addPiloto(String nombre, String apellidos) {
        return this.addPiloto(new Piloto(nombre, apellidos));
    }
    public Dron addDron(String nombre, String fabricante) {
        return this.addDron(new Dron(nombre, fabricante));
    }

    public Piloto getPiloto(String id) {
        logger.info("getPiloto("+id+")");

        for (Piloto p: this.listaPilotos) {
            if (p.getId().equals(id)) {
                logger.info("getPiloto("+id+"): "+p);

                return p;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public Dron getDrone(String id) {
        logger.info("getDron("+id+")");

        for (Dron t: this.drons) {
            if (t.getId().equals(id)) {
                logger.info("getDron("+id+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Dron> findAll() {
        return this.drons;
    }

    @Override
    public void deletePiloto(String id) {

        Piloto t = this.getPiloto(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.listaPilotos.remove(t);

    }

    @Override
    public void deleteDron(String id) {

        Dron t = this.getDrone(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.drons.remove(t);

    }

    @Override
    public Piloto updatePiloto(Piloto t) {
        Piloto p = this.getPiloto(t.getId());

        if (p!=null) {
            logger.info(t+" rebut!!!! ");

            p.setNombre(t.getNombre());
            p.setApellidos(t.getApellidos());


            logger.info(p+" updated ");
        }
        else {
            logger.warn("not found "+t);
        }

        return p;
    }

    @Override
    public Dron updateDron(Dron p) {
        Dron t = this.getDrone(p.getId());

        if (t!=null) {
            logger.info(p+" rebut!!!! ");

            t.setNombre(p.getNombre());
            t.setFabricante(p.getFabricante());

            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return t;
    }
    /*
    @Override
    public List<Dron> dronsbyhoras() {
        List<Dron> list = this.drons;
        list.sort((Dron p1, Dron p2) -> Double.compare(p1.getNumHoras(), p2.getNumHoras()));
        return list;
    }
    @Override
    public int numHoras(String idDrons) {
        int NumHorasActual = 0;
        boolean encontrado = false;
        int j = 0;
        while ((!encontrado) && (j < drons.size())) {
            if (drons.get(j).getId() == idDrons) {
                encontrado = true;
            } else {
                j++;
            }
        }
        if (encontrado) {
            NumHorasActual = drons.get(j).getNumHoras();
        }
        return NumHorasActual;
    }

     */
}