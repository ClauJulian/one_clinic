package com.claujulian.clinica.modelo.consulta.validaciones;

import com.claujulian.clinica.modelo.ValidacionException;
import com.claujulian.clinica.modelo.consulta.ConsultaRepository;
import com.claujulian.clinica.modelo.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoConOtraConsultaEnElMismoHorario implements ValidadorDeConsultas{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosReservaConsulta datos) {

        Boolean medicoTieneOtraConsultaEnElMismoHorario = repository.existsByMedicoIdAndFechaAndMotivoCancelamientoIsNull(datos.idMedico(),datos.fecha());

        if(medicoTieneOtraConsultaEnElMismoHorario){
            throw new ValidacionException("El médico ya tiene otra consulta en esa fecha");
        }
    }
    }
