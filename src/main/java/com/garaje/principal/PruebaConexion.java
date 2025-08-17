package com.garaje.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PruebaConexion {

    public static void main(String[] args) {
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            System.err.println("❌ No se pudo leer el archivo de configuración");
            e.printStackTrace();
            return;
        }

        String url = props.getProperty("db.url");
        String usuario = props.getProperty("db.usuario");
        String contraseña = props.getProperty("db.contraseña");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("✅ Conexión exitosa a la base de datos");
            conexion.close();
        } catch (ClassNotFoundException e) {
            System.out.println("❌ No se encontró el driver JDBC");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos");
            e.printStackTrace();
        }
    }
}
