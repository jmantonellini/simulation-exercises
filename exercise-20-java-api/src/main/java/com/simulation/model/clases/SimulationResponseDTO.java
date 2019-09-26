package com.simulation.model.clases;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimulationResponseDTO {
  double totalAcumulado;
  double costoPromedioPorDia;
  double promedioCabinasHab;
  double montoRecaudado;
  double[] porcTiempoPorCabina;
  double maxCabinasHab;
}
