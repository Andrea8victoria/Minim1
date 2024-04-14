package edu.upc.dsa;

import edu.upc.dsa.models.Dron;

import java.util.*;

import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.PlanVuelo;
import org.apache.log4j.Logger;

public class DronesManagerImpl implements DronesManager {
    private static DronesManager instance;
    protected List<Dron> drons;
    private ArrayList<Piloto> listaPilotos;
    private ArrayList<PlanVuelo> planesVuelos;
    private Stack<Dron> almacens;
    final static Logger logger = Logger.getLogger(DronesManagerImpl.class);

    public DronesManagerImpl(){
        listaPilotos=new ArrayList<>();
        planesVuelos=new ArrayList<>();
        this.drons = new LinkedList<>();
        this.almacens=new Stack<>();
    }

    public int sizePlanVuelo() {
        int ret = this.planesVuelos.size();
        logger.info("sizePlanVuelo " + ret);

        return ret;
    }

    public int sizePiloto() {
        int ret = this.listaPilotos.size();
        logger.info("sizePiloto " + ret);

        return ret;
    }

    public int size() {
        int ret = this.drons.size();
        logger.info("size " + ret);

        return ret;
    }

    @Override
    public int numHoras(String b001) {
        return 0;
    }




////GET
    public static DronesManager getInstance() {
        if (instance==null) instance = new DronesManagerImpl();
        return instance;
    }

    public Stack<Dron> getAlmacen() {return this.almacens;}

    public ArrayList<Piloto> getListaPilotos() {
        return listaPilotos;
    }

    public ArrayList<PlanVuelo> getPlanesVuelos() { return planesVuelos;}

    public List<Dron> findAll() {
        return this.drons;
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

    @Override
    public List<Dron> dronsbyhoras() {
        List<Dron> desclist = new ArrayList<>(this.drons);

        if (!desclist.isEmpty()) {
            Collections.sort(desclist, new Comparator<Dron>() {
                @Override
                public int compare(Dron o1, Dron o2) {
                    return Integer.compare(o2.getNumHoras(), o1.getNumHoras());
                }
            });
            return desclist;
        }else return  null;
    }

    @Override
    public List<Piloto> pilotobyhoras() {
        List<Piloto> desclist = new ArrayList<>(this.listaPilotos);

        if (!desclist.isEmpty()) {
            Collections.sort(desclist, new Comparator<Piloto>() {
                @Override
                public int compare(Piloto o1, Piloto o2) {
                    return Integer.compare(o2.getNumHoras(), o1.getNumHoras());
                }
            });
            return desclist;
        }else return  null;
    }



////ADD
    public Piloto addPiloto(String nombre, String apellidos, int numHoras) {
        return this.addPiloto(new Piloto(nombre, apellidos, numHoras));
    }

    public Dron addDron(String id,String nombre, String fabricante, String modelo, int numHoras) {
        return this.addDron(new Dron(id, nombre, fabricante, modelo, numHoras));
    }

    public PlanVuelo addPlanVuelo(String idDron, String fecha, String tiempo, String origen, String destino, String piloto) {
        return this.addPlanVuelo(new PlanVuelo(idDron, fecha, tiempo, origen, destino, piloto));
    }

    public PlanVuelo addPlanVuelo(PlanVuelo planVuelo) {
        logger.info("new PlanVuelo " + planVuelo);

        this.planesVuelos.add (planVuelo);
        logger.info("new PlanVuelo added");
        return planVuelo;
    }

    public Piloto addPiloto(Piloto p) {
        logger.info("new Piloto " + p);

        this.listaPilotos.add (p);
        logger.info("new Piloto added");
        return p;
    }

    public Dron addDron(Dron t) {
        logger.info("new Dron " + t);

        this.drons.add (t);
        logger.info("new Dron added");
        return t;
    }

    @Override
    public void addAlmacen(String id) {
        Dron t = this.getDrone(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" saved ");

        this.almacens.add(t);
    }




////DELETE
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
    public void deleteAlmacen() {this.almacens.pop();}



////UPDATE
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

}