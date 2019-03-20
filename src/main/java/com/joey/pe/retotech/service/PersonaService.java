package com.joey.pe.retotech.service;

import com.joey.pe.retotech.Assembler.PersonaAssembler;
import com.joey.pe.retotech.dto.KpiClienteDto;
import com.joey.pe.retotech.dto.PersonaCustomDto;
import com.joey.pe.retotech.dto.PersonaDto;
import com.joey.pe.retotech.entity.Persona;
import com.joey.pe.retotech.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaAssembler personaAssembler;

    public Integer savePersona(PersonaDto persona) {
      Persona entity= personaRepository.save(personaAssembler.fromPersonaDto(persona));
      return entity.getId();
    }

    public List<Persona> getAll() {
        List<Persona> list = new ArrayList<>();
        personaRepository.findAll().forEach(p -> list.add(p));
        return list;
    }

    public KpiClienteDto getKpiCliente() {
        List<Persona> personas = getAll();
        if (Optional.ofNullable(personas).isPresent() && !personas.isEmpty()) {
            Double promedio = getPromedio(personas.stream().map(Persona::getEdad).collect(Collectors.toList()));
            Double desviacion = getDesviacionEstandar(personas.stream().map(Persona::getEdad).collect(Collectors.toList()));
            return new KpiClienteDto(promedio, desviacion);
        } else {
            return new KpiClienteDto(0, 0);
        }
    }

    private Double getPromedio(List<Integer> values) {
        Integer sum = values.stream().mapToInt(p -> p).sum();
        Double promedio = Double.valueOf(sum / values.size());
        return promedio;
    }

    private Double getDesviacionEstandar(List<Integer> values) {
        Double promedio = getPromedio(values);
        //suma el cuadrado de las distancias
        Double desviacion = values.stream().mapToDouble(p -> Math.pow(p - promedio, 2)).sum();
        //divide la desviacion entre el total de elementos
        desviacion = desviacion / values.size();
        //raiz cuadrada del resultado
        desviacion = Math.sqrt(desviacion);
        return desviacion;
    }

    public List<PersonaCustomDto> getAllPerson() {
        List<PersonaCustomDto> list = new ArrayList<>();
        personaRepository.findAll().forEach(p -> list.add(personaAssembler.fromPersona(p)));
        return list;
    }

}
