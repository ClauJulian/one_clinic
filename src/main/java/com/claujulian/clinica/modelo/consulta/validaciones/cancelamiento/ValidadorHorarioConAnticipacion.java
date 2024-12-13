package com.claujulian.clinica.modelo.consulta.validaciones.cancelamiento;

import com.claujulian.clinica.modelo.consulta.ConsultaRepository;
import com.claujulian.clinica.modelo.consulta.DatosCancelamientoConsulta;
import com.claujulian.clinica.modelo.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioConAnticipacion implements ValidadorCancelamientoConsulta{

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DatosCancelamientoConsulta datos) {
        var consulta = repository.getReferenceById(datos.idConsulta());
        var ahora = LocalDateTime.now();
        var diferenciaEnHoras = Duration.between(ahora, consulta.getFecha()).toHours();
    }
}
