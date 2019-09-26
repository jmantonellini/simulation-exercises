package com.simulation.model.clases;

import java.util.Date;
import java.util.LinkedList;

public class Vehiculo {
    private int id;
    private static int nextId = 0;

    public Vehiculo(Date hora) {
        this.id = nextId;
        nextId++;
    }

    public Date horaInicioAtencion;
    public Date horaIngresoCola;

}
