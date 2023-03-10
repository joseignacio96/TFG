package com.example.prueba2.Modelo;

import java.sql.*;

public class Conexion {
    private String url = "jdbc:mysql://127.0.0.1:3306/musica";

    private String user = "root";

    private String password = "";
    Connection conectar;

    public void conectar() {
        try {
            conectar = DriverManager.getConnection(url,user,password);
            System.out.println("Conectado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void desconectar() {
        try {
            conectar.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
