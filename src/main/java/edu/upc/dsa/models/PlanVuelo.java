package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;
import org.yaml.snakeyaml.util.ArrayStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class PlanVuelo {
    String idDron;
    String fecha;
    String tiempo;
    String origen;
    String destino;
    String piloto;

    //constructor
    public PlanVuelo(String idDron, String fecha, String tiempo, String origen, String destino, String piloto) {
        this.setIdDron(idDron);
        this.setFecha(fecha);
        this.setTiempo(tiempo);
        this.setOrigen(origen);
        this.setDestino(destino);
        this.setPiloto(piloto);
    }

    public String getIdDron() {
        return idDron;
    }

    public void setIdDron(String idDron) {
        this.idDron = idDron;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    @Override
    public String toString() {
        return "PlanVuelo [idDron="+idDron+", fecha=" + fecha + ", tiempo=" + tiempo +", origen=" + origen +", destino=" + destino +", piloto=" + piloto +"]";
    }
}
