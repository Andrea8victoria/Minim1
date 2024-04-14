package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.PlanVuelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public interface DronesManager {

    //DRON
    public Dron addDron(String id, String nombre, String fabricante, String modelo, int NumHoras);
    public Dron addDron(Dron t);
    public void addAlmacen (String id);

    public void deleteAlmacen();
    public void deleteDron(String id);

    public List<Dron> findAll();
    public Stack<Dron> getAlmacen();
    public Dron getDrone(String id);
    public List<Dron> dronsbyhoras();

    public Dron updateDron(Dron t);


    //PILOTO
    public Piloto addPiloto(String nombre, String apellidos, int NumHoras);
    public Piloto addPiloto(Piloto p);

    public Piloto getPiloto(String id);
    public ArrayList<Piloto> getListaPilotos();
    public List<Piloto> pilotobyhoras();

    public void deletePiloto(String id);

    public Piloto updatePiloto(Piloto p);


    //PLAN VUELO
    public PlanVuelo addPlanVuelo(String idDron, String fecha, String tiempo, String origen, String destino, String piloto);
    public PlanVuelo addPlanVuelo(PlanVuelo planVuelo);

    public ArrayList<PlanVuelo> getPlanesVuelos();


    //OTROS
    public int size();

    public int sizePiloto();

    public int sizePlanVuelo();

    public int numHoras(String b001);

}
