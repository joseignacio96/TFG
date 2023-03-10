package com.example.prueba2.Modelo;

public class Cancion {
    int id;
    String nombreCancion;
    double duracion;
    String genero;
    int artista;

    String ruta;

    String nombreFichero;

    public String getNombreFichero() {
        return nombreFichero;
    }

    public void setNombreFichero(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getArtista() {
        return artista;
    }

    public void setArtista(int artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", nombreCancion='" + nombreCancion + '\'' +
                ", duracion=" + duracion +
                ", genero='" + genero + '\'' +
                ", artista=" + artista +
                '}';
    }
}
