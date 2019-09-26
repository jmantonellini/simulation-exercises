package com.simulation.model.clases;

import java.util.Date;
import java.util.LinkedList;

public class Cabina {
    private int numero;
    private boolean habilitada;
    private Vehiculo vehiculo;
    private Date tiempoHabilitada;
    private Date tiempoLiberada;
    private EstadosCabina estado;


    public boolean isLibre() {
        return this.estado == EstadosCabina.LIBRE;
    }

    public boolean isOcupada() {
        return this.estado == EstadosCabina.OCUPADA;
    }

    public void setOcupada() {
        this.estado = EstadosCabina.OCUPADA;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    //Se hace un enum para posibilitar agregar futuros estados
    public enum EstadosCabina {
        LIBRE, OCUPADA;
    }
}
