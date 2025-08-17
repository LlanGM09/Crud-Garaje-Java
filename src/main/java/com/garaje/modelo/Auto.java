package com.garaje.modelo;

public class Auto {
    private int id;
    private String marca;
    private String modelo;
    private String tipoMotor;
    private int potencia;

    // Constructores

    public Auto(int id, String marca, String modelo, String tipoMotor, int potencia) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.potencia = potencia;
    }

    public Auto(String marca, String modelo, String tipoMotor, int potencia) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.potencia = potencia;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getTipoMotor() { return tipoMotor; }
    public void setTipoMotor(String tipoMotor) { this.tipoMotor = tipoMotor; }

    public int getPotencia() { return potencia; }
    public void setPotencia(int potencia) { this.potencia = potencia; }

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-15s %-12s %-5d",
                id, marca, modelo, tipoMotor, potencia);
    }
}