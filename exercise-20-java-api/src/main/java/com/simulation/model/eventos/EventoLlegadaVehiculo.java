package com.simulation.model.eventos;

import com.simulation.model.clases.Cabina;
import com.simulation.model.clases.Peaje;
import com.simulation.model.clases.Vehiculo;
import com.simulation.service.SimulationServiceImpl;

import java.util.Date;

public class EventoLlegadaVehiculo extends Evento {
    @Override
    public void consume() {
        Vehiculo vehiculo = new Vehiculo(this.getHora());
        Cabina cabinaLibre = Peaje.getCabinaLibre();
        if (null != cabinaLibre) {
            cabinaLibre.setOcupada();
            cabinaLibre.setVehiculo(vehiculo);
            vehiculo.horaInicioAtencion = getHora();
            MesaEntradaGenerator.generate(getHora(), factura, cabinaLibre);
        } else {
            vehiculo.horaIngresoCola = getHora();
            SimulationServiceImpl.addToCola(vehiculo);
        }
        FacturaContadoGenerator.generate(getHora());
    }

    @Override
    public String getName() {
        return "Llegada de Factura Contado";
    }

    public EventoLlegadaFacturaContado(Date hora) {
        super(hora);
    }
}
}
