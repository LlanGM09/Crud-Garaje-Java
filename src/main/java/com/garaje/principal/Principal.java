package com.garaje.principal;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.garaje.dao.AutoDao;
import com.garaje.modelo.Auto;
import com.garaje.modelo.Motor;
import com.garaje.modelo.Garaje;

public class Principal {

    public static void main(String[] args) {

        //Creamos el motor del auto
        Motor motor = new Motor("Gasolina", 130);

        //Creamos el auto con marca modelo y motor
        Auto auto = new Auto("Toyota", "Corolla", motor);

        //Crear instancia del DAO
        AutoDao autoDAO = new AutoDao();

        //Insertar el auto en la base de datos
        autoDAO.insertarAuto(auto);

        // Llamamos al método para obtener la lista de autos desde la base de datos
        List<Auto> autos = autoDAO.listarAutos();

        // Mostramos los autos obtenidos en consola
        for (Auto a : autos) {
            System.out.println("ID: " + a.getId());
            System.out.println("Marca: " + a.getMarca());
            System.out.println("Modelo: " + a.getModelo());
            System.out.println("Tipo de motor: " + a.getMotor().getTipo());
            System.out.println("Potencia: " + a.getMotor().getPotencia());
            System.out.println("--------------------------");
        }




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


        Scanner scanner = new Scanner(System.in);
        Garaje garaje = new Garaje ();

        //Cargar Autos desd el archivo de texto al iniciar
        garaje.cargarAutosDesdeArchivo("autos.txt");

        int opcion;

        do {
            System.out.println("\\n=== MENÚ DEL GARAJE ===");
            System.out.println("1. Mostrar autos");
            System.out.println("2. Buscar por modelo");
            System.out.println("3. Eliminar por modelo");
            System.out.println("4. Agregar nuevo auto");
            System.out.println("5. Salir");
            System.out.println("6. Guardar en archivo de texto (.txt)");
            System.out.println("7. Cargar desde archivo de texto (.txt)");
            System.out.println("8. Guardar en archivo binario (.dat)");
            System.out.println("9. Cargar desde archivo binario (.dat)");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch(opcion) {
                case 1:
                    garaje.mostrarAutos();
                    break;
                case 2:
                    System.out.print("Modelo a buscar: ");
                    String modeloBuscar = scanner.nextLine();
                    garaje.buscarPorModelo(modeloBuscar);
                    break;

                case 3:
                    System.out.print("Modelo a eliminar: ");
                    String modeloEliminar = scanner.nextLine();
                    garaje.eliminarTodosPorModelo(modeloEliminar);
                    break;
                case 4:
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Tipo de motor: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Potencia del motor (HP): ");
                    int potencia = scanner.nextInt();
                    scanner.nextLine();

                    Motor nuevoMotor = new Motor(tipo, potencia);
                    Auto nuevoAuto = new Auto(marca, modelo, nuevoMotor);
                    garaje.agregarAuto(nuevoAuto);
                    System.out.println("✅ Auto agregado con éxito.");
                    break;
                case 5:
                    System.out.println("👋 ¡Gracias por usar el sistema del garaje!");
                    break;
                case 6:
                    garaje.guardarAutosEnArchivo("autos.txt");
                    break;
                case 7:
                    garaje.cargarAutosDesdeArchivo("autos.txt");
                    break;
                case 8:
                    garaje.guardarAutosComoObjeto("autos.dat");
                    break;
                case 9:
                    garaje.cargarAutosDesdeObjeto("autos.dat");
                    break;
                default:
                    System.out.println("⚠️ Opción inválida.");

            }

        } while (opcion != 5);

        // Guardar automáticamente al salir
        garaje.guardarAutosEnArchivo("autos.txt");
        scanner.close();
    }

    private static Connection obtenerConexion() {
        // TODO Auto-generated method stub
        return null;
    }
}*/
