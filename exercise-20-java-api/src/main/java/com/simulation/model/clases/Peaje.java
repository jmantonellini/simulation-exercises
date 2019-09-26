package com.simulation.model.clases;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Peaje {
    private static List<Cabina> cabinaList;

    public static void inicializar(int cantCabinas) {
        cabinaList = new LinkedList<>();
        for (int i = 0; i < cantCabinas; i++) {
            cabinaList.add(new Cabina());
        }
    }

    public static Cabina getCabinaLibre() {
        for (Cabina cabina :
                cabinaList) {
            if (cabina.isLibre()) {
                return cabina;
            }
        }
        return null;
    }

    public static int getCabinasOcupadas() {
        int cantCabinasOcupadas = 0;
        for (Cabina cabina : cabinaList) {
            if (cabina.isOcupada()) {
                cantCabinasOcupadas++;
            }
        }
        return cantCabinasOcupadas;
    }

    public static Iterator<Cabina> getCabinasIterator() {
        return cabinaList.iterator();
    }
}
