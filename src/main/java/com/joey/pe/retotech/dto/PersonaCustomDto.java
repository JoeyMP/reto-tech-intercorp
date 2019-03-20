package com.joey.pe.retotech.dto;

import java.util.Date;

public class PersonaCustomDto extends PersonaDto {

    private Integer id;
    private Date fechaProbableMuerte;

    public PersonaCustomDto(String nombre, String apellido, int edad, Date fechaNacimiento, Integer id, Date fechaProbableMuerte) {
        super(nombre, apellido, edad, fechaNacimiento);
        this.id = id;
        this.fechaProbableMuerte = fechaProbableMuerte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaProbableMuerte() {
        return fechaProbableMuerte;
    }

    public void setFechaProbableMuerte(Date fechaProbableMuerte) {
        this.fechaProbableMuerte = fechaProbableMuerte;
    }
}
