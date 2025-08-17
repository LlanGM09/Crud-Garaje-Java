package com.garaje.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class ConfigDB {

    // Cargar las variables desde el archivo .env
    private static final Dotenv dotenv = Dotenv.load();

    // Método para obtener la conexión
    public static Connection conectar() throws SQLException {
        String url = dotenv.get("DB_URL");
        String usuario = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        return DriverManager.getConnection(url, usuario, password);
    }
}
