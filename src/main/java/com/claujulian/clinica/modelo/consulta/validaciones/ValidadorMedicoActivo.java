package com.claujulian.clinica.modelo.consulta.validaciones;

import com.claujulian.clinica.modelo.ValidacionException;
import com.claujulian.clinica.modelo.consulta.DatosReservaConsulta;
import com.claujulian.clinica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoActivo implements ValidadorDeConsultas{

    @Autowired
    private MedicoRepository repository;

    public void validar(DatosReservaConsulta datos) {

        if(datos.idMedico() == null){
            return;
        }
        var medicoEstaActivo = repository.findActivoById(datos.idMedico());

        if(!medicoEstaActivo){
            throw new ValidacionException("La consulta no puede ser reservada con un médico no activo");
        }

    }
}
