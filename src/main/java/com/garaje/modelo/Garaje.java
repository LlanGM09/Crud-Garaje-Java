package com.garaje.modelo;

import java.util.*;


import java.util.ArrayList;
import java.util.List;

    public class Garaje {
        private List<Auto> autos;

        public Garaje() {
            autos = new ArrayList<>();
        }

        // Agregar auto
        public void agregarAuto(Auto auto) {
            autos.add(auto);
        }

        // Mostrar autos
        public void mostrarAutos() {
            if (autos.isEmpty()) {
                System.out.println("🚗 No hay autos en el garaje.");
                return;
            }

            System.out.printf("%-5s %-15s %-15s %-12s %-5s\n",
                    "ID", "Marca", "Modelo", "Motor", "Pot.");
            System.out.println("---------------------------------------------------");

            for (Auto auto : autos) {
                System.out.println(auto);
            }
        }

        // Buscar auto por modelo
        public Auto buscarPorModelo(String modelo) {
            for (Auto auto : autos) {
                if (auto.getModelo().equalsIgnoreCase(modelo)) {
                    return auto;
                }
            }
            return null;
        }

        // Eliminar auto por modelo
        public boolean eliminarPorModelo(String modelo) {
            Auto auto = buscarPorModelo(modelo);
            if (auto != null) {
                autos.remove(auto);
                return true;
            }
            return false;
        }

        // Obtener lista de autos
        public List<Auto> getAutos() {
            return autos;
        }
    }


