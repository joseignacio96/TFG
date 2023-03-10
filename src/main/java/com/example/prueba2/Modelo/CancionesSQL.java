package com.example.prueba2.Modelo;

import com.example.prueba2.Main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CancionesSQL {

    Conexion conectar = new Conexion();
    public Cancion mostrarDatos() {
        Cancion cancion = new Cancion();
        conectar.conectar();
        String sql = "SELECT * FROM canciones";

        try {
            Statement statement = conectar.conectar.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                cancion = new Cancion();
                cancion.setId(resultSet.getInt("id"));
                cancion.setNombreCancion(resultSet.getString("nombre_cancion"));
                cancion.setDuracion(resultSet.getInt("duracion"));
                cancion.setGenero(resultSet.getString("genero"));
                cancion.setArtista(resultSet.getInt("artista"));
                cancion.setRuta(resultSet.getString("ruta"));
                cancion.setNombreFichero(resultSet.getString("nombre_fichero"));
                Main.listCanciones.add(cancion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cancion;
    }

}
