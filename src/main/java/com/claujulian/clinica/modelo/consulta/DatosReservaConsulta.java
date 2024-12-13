package com.claujulian.clinica.modelo.consulta;

import com.claujulian.clinica.modelo.Especialidad;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosReservaConsulta(

        @NotNull
        Long idPaciente,

        Long idMedico,

        @NotNull
        @Future
        LocalDateTime fecha,

        Especialidad especialidad
) {
}
