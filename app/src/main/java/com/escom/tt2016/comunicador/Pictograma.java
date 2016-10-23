package com.escom.tt2016.comunicador;

/**
 * creamos una clase llamada Pictograma que sera el modelo que representara
 * la tabla Pictograma de la base de datos.
 * */
public class Pictograma {
    public String id;
    public String nombre;
    public String categoria;
    public int idDrawable;

    public Pictograma(String id, String nombre, String categoria, int idDrawable) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.idDrawable = idDrawable;
    }

    public Pictograma() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public void setIdDrawable(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    @Override
    public String toString() {
        return nombre;
    }

}