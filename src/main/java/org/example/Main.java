package org.example;

import java.sql.SQLException;
import com.garaje.dao.AutoDao;
import com.garaje.menu.Menu;

public class Main {

    public static void main(String[] args) {
        AutoDao autoDao = new AutoDao();  // Instancia DAO
        Menu menu = new Menu(autoDao);    // Instancia menú

        try {
            menu.mostrarMenu(); // Todo el menú y bucle están aquí
        } catch (SQLException e) {
            System.err.println("⚠ Error de base de datos: " + e.getMessage());
        }
    }
}
