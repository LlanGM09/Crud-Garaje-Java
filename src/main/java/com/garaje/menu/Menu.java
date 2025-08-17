package com.garaje.menu;

import com.garaje.dao.AutoDao;
import com.garaje.modelo.Auto;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private AutoDao autoDao;
    private Scanner scanner;

    public Menu(AutoDao autoDao) {
        this.autoDao = autoDao;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() throws SQLException {
        int opcion = 0;
        do {
            System.out.println("\n=== MENÚ GARAJE ===");
            System.out.println("1. Listar autos");
            System.out.println("2. Agregar auto");
            System.out.println("3. Actualizar auto");
            System.out.println("4. Eliminar auto");
            System.out.println("5. Buscar por marca");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                switch (opcion) {
                    case 1 -> listarAutos();
                    case 2 -> agregarAuto();
                    case 3 -> actualizarAuto();
                    case 4 -> eliminarAuto();
                    case 5 -> buscarPorMarca();
                    case 6 -> System.out.println("Saliendo...");
                    default -> System.out.println("⚠ Opción inválida, intente de nuevo.");
                }
            } else {
                System.out.println("⚠ Entrada inválida, ingrese un número.");
                scanner.nextLine(); // limpiar buffer
            }

        } while (opcion != 6);
    }

    private void listarAutos() throws SQLException {
        List<Auto> autos = autoDao.listarAutos();
        if (autos.isEmpty()) {
            System.out.println("⚠ No hay autos registrados.");
            return;
        }
        System.out.printf("%-5s %-15s %-15s %-12s %-6s%n", "ID", "Marca", "Modelo", "Tipo Motor", "Pot.");
        System.out.println("---------------------------------------------------------------");
        for (Auto auto : autos) {
            System.out.printf("%-5d %-15s %-15s %-12s %-6d%n",
                    auto.getId(), auto.getMarca(), auto.getModelo(),
                    auto.getTipoMotor(), auto.getPotencia());
        }
    }

    private void agregarAuto() throws SQLException {
        System.out.print("Ingrese marca: ");
        String marca = scanner.nextLine().trim();
        if (marca.isEmpty()) {
            System.out.println("⚠ La marca no puede estar vacía.");
            return;
        }

        System.out.print("Ingrese modelo: ");
        String modelo = scanner.nextLine().trim();
        if (modelo.isEmpty()) {
            System.out.println("⚠ El modelo no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese tipo de motor: ");
        String tipoMotor = scanner.nextLine().trim();
        if (tipoMotor.isEmpty()) {
            System.out.println("⚠ El tipo de motor no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese potencia: ");
        if (!scanner.hasNextInt()) {
            System.out.println("⚠ Potencia inválida.");
            scanner.nextLine();
            return;
        }
        int potencia = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Auto auto = new Auto(marca, modelo, tipoMotor, potencia);
        autoDao.insertarAuto(auto);
        System.out.println("✅ Auto agregado correctamente.");
    }

    private void actualizarAuto() throws SQLException {
        System.out.print("Ingrese ID del auto a actualizar: ");
        if (!scanner.hasNextInt()) {
            System.out.println("⚠ ID inválido.");
            scanner.nextLine();
            return;
        }
        int id = scanner.nextInt();
        scanner.nextLine();

        Auto existente = autoDao.buscarPorId(id);
        if (existente == null) {
            System.out.println("⚠ No se encontró el auto con ID " + id);
            return;
        }

        System.out.print("Ingrese nueva marca (" + existente.getMarca() + "): ");
        String marca = scanner.nextLine().trim();
        if (!marca.isEmpty()) existente.setMarca(marca);

        System.out.print("Ingrese nuevo modelo (" + existente.getModelo() + "): ");
        String modelo = scanner.nextLine().trim();
        if (!modelo.isEmpty()) existente.setModelo(modelo);

        System.out.print("Ingrese nuevo tipo de motor (" + existente.getTipoMotor() + "): ");
        String tipoMotor = scanner.nextLine().trim();
        if (!tipoMotor.isEmpty()) existente.setTipoMotor(tipoMotor);

        System.out.print("Ingrese nueva potencia (" + existente.getPotencia() + "): ");
        if (scanner.hasNextInt()) {
            int potencia = scanner.nextInt();
            existente.setPotencia(potencia);
        } else {
            System.out.println("⚠ Potencia no modificada.");
        }
        scanner.nextLine(); // limpiar buffer

        autoDao.actualizarAuto(existente);
        System.out.println("✅ Auto actualizado correctamente.");
    }

    private void eliminarAuto() throws SQLException {
        System.out.print("Ingrese ID del auto a eliminar: ");
        if (!scanner.hasNextInt()) {
            System.out.println("⚠ ID inválido.");
            scanner.nextLine();
            return;
        }
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean eliminado = autoDao.eliminarAuto(id);
        if (eliminado) {
            System.out.println("✅ Auto eliminado correctamente.");
        } else {
            System.out.println("⚠ No se encontró el auto con ID " + id);
        }
    }

    private void buscarPorMarca() throws SQLException {
        System.out.print("Ingrese marca a buscar: ");
        String marca = scanner.nextLine().trim();
        List<Auto> autos = autoDao.buscarPorMarca(marca);

        if (autos.isEmpty()) {
            System.out.println("⚠ No se encontraron autos con la marca: " + marca);
            return;
        }

        System.out.printf("%-5s %-15s %-15s %-12s %-6s%n", "ID", "Marca", "Modelo", "Tipo Motor", "Pot.");
        System.out.println("---------------------------------------------------------------");
        for (Auto auto : autos) {
            System.out.printf("%-5d %-15s %-15s %-12s %-6d%n",
                    auto.getId(), auto.getMarca(), auto.getModelo(),
                    auto.getTipoMotor(), auto.getPotencia());
        }
    }
}