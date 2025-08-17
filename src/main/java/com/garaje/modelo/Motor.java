package com.garaje.modelo;

import java.io.Serializable;
public class Motor implements Serializable {

    private static final long serialVersionUID = 1L;

    //Atributos
    private String tipo;
    private int potencia;

    //Constructor
    public Motor(String tipo, int potencia) {
        this.tipo = tipo;
        this.potencia = potencia;
    }

    //Getters
    public String getTipo() {
        return tipo;
    }

    //Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //Getters
    public int getPotencia() {
        return potencia;
    }

    //Setters
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return tipo + "-" + potencia + "HP";
    }

}
