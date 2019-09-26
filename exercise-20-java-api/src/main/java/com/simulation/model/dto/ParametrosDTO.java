package com.simulation.model.dto;

import lombok.Data;

import java.sql.Time;

@Data
public class ParametrosDTO {

    private Time horasSimulacion;
    private int cantReposicion;
    private int nivelReposicion;
    private int diasParaReponer;
    private int stockInicial;
    private int costoMantenimiento;
    private int costoOrdenamiento;
    private int costoStockout;
    private int diasParaPagarStockOut;

}
