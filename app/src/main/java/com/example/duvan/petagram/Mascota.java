package com.example.duvan.petagram;


public class Mascota {

    private String nombre;
    private int imagen;

    public Mascota(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
