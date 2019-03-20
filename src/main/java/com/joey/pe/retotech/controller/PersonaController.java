package com.joey.pe.retotech.controller;

import com.joey.pe.retotech.dto.KpiClienteDto;
import com.joey.pe.retotech.dto.PersonaCustomDto;
import com.joey.pe.retotech.dto.PersonaDto;
import com.joey.pe.retotech.entity.Persona;
import com.joey.pe.retotech.service.PersonaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@Api(value = "Operaciones Persona", description = "Servicios para la entidad Persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/creacliente")
    @ApiOperation(value = "Registra la informacion de una nueva persona",
            notes = "El codigo de usuario es auto generado")
    private ResponseEntity<Integer> savePersona(@RequestBody PersonaDto persona) {
        Integer id = personaService.savePersona(persona);
        return new ResponseEntity(id, HttpStatus.CREATED);
    }

    @GetMapping("/kpideclientes")
    @ApiOperation(value = "Retorna promedio y desviacion estandar de todas las personas",
            notes = "Si no hay personas registradas, los valores seran 0")
    private ResponseEntity<KpiClienteDto> getKpiPersona() {
        return new ResponseEntity(personaService.getKpiCliente(), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna la lista de personas incluido la fecha probable de muerte",
            notes = "")
    @GetMapping("/listclientes")
    private ResponseEntity<List<PersonaCustomDto>> getAll() {
        return new ResponseEntity(personaService.getAllPerson(), HttpStatus.OK);
    }
}
