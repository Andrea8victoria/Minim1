package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.PlanVuelo;

import java.util.ArrayList;
import java.util.List;

public interface DronesManager {


    public Dron addDron(String nombre, String fabricante);
    public Dron addDron(Dron t);
    public Dron getDrone(String id);
    public List<Dron> findAll();
    public void deleteDron(String id);
    public Dron updateDron(Dron t);
    //public List<Dron> dronsbyhoras();

    public Piloto addPiloto(String nombre, String apellidos);
    public Piloto addPiloto(Piloto p);
    public Piloto getPiloto(String id);
    public ArrayList<Piloto> getListaPilotos();
    public void deletePiloto(String id);
    public Piloto updatePiloto(Piloto p);
    //public List<Piloto> pilotobyhoras();

    //public PlanVuelo addPlanVuelo(String idDron, String fecha, String tiempo, String origen, String destino, String piloto);

    public int size();
    //public int numHoras(String b001);
}
