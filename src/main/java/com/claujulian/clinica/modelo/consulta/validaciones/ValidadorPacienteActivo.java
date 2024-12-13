package com.claujulian.clinica.modelo.consulta.validaciones;

import com.claujulian.clinica.modelo.ValidacionException;
import com.claujulian.clinica.modelo.consulta.DatosReservaConsulta;
import com.claujulian.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteActivo implements ValidadorDeConsultas{

    @Autowired
    private PacienteRepository repository;

    public void validar(DatosReservaConsulta datos) {
        var pacienteEstaActivo = repository.findActivoById(datos.idPaciente());

        if(!pacienteEstaActivo){
            throw new ValidacionException("La consulta no puede ser reservada a un paciente no activo");
        }

    }
}
