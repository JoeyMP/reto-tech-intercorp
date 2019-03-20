package com.joey.pe.retotech.dto;

public class KpiClienteDto {
    private double promedio;
    private double desviacionEstandar;

    public KpiClienteDto() {
    }

    public KpiClienteDto(double promedio, double desviacionEstandar) {
        this.promedio = promedio;
        this.desviacionEstandar = desviacionEstandar;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getDesviacionEstandar() {
        return desviacionEstandar;
    }

    public void setDesviacionEstandar(double desviacionEstandar) {
        this.desviacionEstandar = desviacionEstandar;
    }
}
