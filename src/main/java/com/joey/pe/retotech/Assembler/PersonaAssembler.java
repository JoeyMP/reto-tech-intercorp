package com.joey.pe.retotech.Assembler;

import com.joey.pe.retotech.dto.PersonaCustomDto;
import com.joey.pe.retotech.dto.PersonaDto;
import com.joey.pe.retotech.entity.Persona;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PersonaAssembler {

    public PersonaCustomDto fromPersona(Persona persona) {
        return new PersonaCustomDto(
                persona.getNombre(),
                persona.getApellido(),
                persona.getEdad(),
                persona.getFechaNacimiento(),
                persona.getId(),
                new Date());
    }

    public Persona fromPersonaDto(PersonaDto persona) {
        return new Persona(
                persona.getNombre(),
                persona.getApellido(),
                persona.getEdad(),
                persona.getFechaNacimiento());
    }

}
