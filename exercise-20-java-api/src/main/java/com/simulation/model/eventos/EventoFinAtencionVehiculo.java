package com.simulation.model.eventos;

import com.simulation.model.clases.Cabina;

import java.util.Date;

public class EventoFinAtencionVehiculo extends Evento{

    private Cabina cabina;

    public EventoFinAtencionVehiculo(Cabina cabina, Date finAtencion) {
        super(finAtencion);
        this.cabina = cabina;
    }

    @Override
    public void consume() {
        empleadoRegistro.getFactura().setHoraFinAtencionTerminales(getHora());
        if (!rechazarFactura()) {
            empleadoRegistro.setOcupado();
            empleadoRegistro.getFactura().setHoraInicioSelloAprobado(getHora());
            SelloAprobadoGenerator.generate(getHora(), empleadoRegistro);
        } else {
            empleadoRegistro.setOcupado();
            empleadoRegistro.getFactura().setHoraInicioSelloRechazado(getHora());
            SelloRechazadoGenerator.generate(getHora(), empleadoRegistro);
        }
        if(MainLoop.isTerminalesQueueEmpty()) {
            terminal.setLibre();
        } else {
            empleadoRegistro.getFactura().setHoraInicioAtencionTerminales(getHora());
            terminal.setOcupado();
            terminal.setEmpleadoRegistro(empleadoRegistro);
            TerminalGenerator.generate(getHora(), MainLoop.popTerminalesQueue(), terminal);
        }
    }

    @Override
    public String getName() {
        return "Fin Atención Cabina";
    }
}
