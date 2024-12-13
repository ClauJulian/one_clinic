package com.claujulian.clinica.modelo.consulta.validaciones;

import com.claujulian.clinica.modelo.ValidacionException;
import com.claujulian.clinica.modelo.consulta.ConsultaRepository;
import com.claujulian.clinica.modelo.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSinOtraConsultaEnElMismoDia implements ValidadorDeConsultas{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosReservaConsulta datos) {
        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(18);
        Boolean pacienteTieneOtraConsultaEnElDia = repository.existsByPacienteIdAndMotivoCancelamientoIsNullAndFechaBetween(datos.idPaciente(), primerHorario,ultimoHorario);

        if(pacienteTieneOtraConsultaEnElDia){
            throw new ValidacionException("El Paciente ya tiene una consulta reservada en el mismo dia");
        }
    }
}
