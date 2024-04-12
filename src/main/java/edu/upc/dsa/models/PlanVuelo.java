package edu.upc.dsa.models;

public class PlanVuelo {
    String idDron;
    String fecha;
    String tiempo;
    String origen;
    String destino;
    String piloto;
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


}
