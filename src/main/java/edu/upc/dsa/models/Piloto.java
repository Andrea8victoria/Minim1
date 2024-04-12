package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Piloto {
    String id;
    String nombre;
    String apellidos;
    private int NumHoras;

    public int getNumHoras() {
        return NumHoras;
    }

    public void setNumHoras(int numHoras) {
        NumHoras = numHoras;
    }

    static int lastId;

    public Piloto() {
        this.id = RandomUtils.getId();
    }

    public Piloto(String nombre, String apellidos) {
        this();
        this.setApellidos(apellidos);
        this.setNombre(nombre);
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Piloto [id="+id+", nombre=" + nombre + ", apellidos=" + apellidos +"]";
    }

}
