package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Dron {

    String id;
    String nombre;
    String fabricante;
    String modelo;
    private int NumHoras;
    List<Almacen> almacens;
    static int lastId;

    public Dron(String id) {
        almacens = new ArrayList<Almacen>();
    }

    public void addAlmacen(String id) {
        almacens.add(new Almacen(id));
    }

    public Almacen getAlmacen(int i) {
        return almacens.get(i);
    }

    public Dron() {
        this.id = RandomUtils.getId();
    }

    public Dron(String nombre, String fabricante) {
        this();
        this.setNombre(nombre);
        this.setFabricante(fabricante);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id=id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumHoras() {
        return NumHoras;
    }

    public void setNumHoras(int numHoras) {
        NumHoras = numHoras;
    }

    @Override
    public String toString() {
        return "Dron [id="+id+", nombre=" + nombre + ", fabricante=" + fabricante +", modelo=" + modelo +"]";
    }

}