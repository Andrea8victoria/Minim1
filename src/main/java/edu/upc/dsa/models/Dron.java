package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;
import org.yaml.snakeyaml.util.ArrayStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Dron {

    String id;
    String nombre;
    String fabricante;
    String modelo;
    private int NumHoras;

    static int lastId;

    //id aleatorio
    public Dron() {
        this.id = RandomUtils.getId();
    }

    //constructor
    public Dron(String id, String nombre, String fabricante, String modelo, int numHoras) {
        this.id = RandomUtils.getId();
        this.setNombre(nombre);
        this.setFabricante(fabricante);
        this.setModelo(modelo);
        this.setNumHoras(numHoras);
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