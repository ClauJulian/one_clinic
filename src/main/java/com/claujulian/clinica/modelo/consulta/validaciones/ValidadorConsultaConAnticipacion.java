package com.claujulian.clinica.modelo.consulta.validaciones;

import com.claujulian.clinica.modelo.ValidacionException;
import com.claujulian.clinica.modelo.consulta.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorConsultaConAnticipacion implements ValidadorDeConsultas{

    public void validar(DatosReservaConsulta datos) {
        var anticipacionMinima = 30;
        var fechaConsulta = datos.fecha();
        var ahora = LocalDateTime.now();
        var diferenciaEnMinutos = Duration.between(ahora, fechaConsulta).toMinutes();

        if(diferenciaEnMinutos < anticipacionMinima){
            throw new ValidacionException("Su consulta no cumple el requisito de anticipación");
        }
    }
}