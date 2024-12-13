package com.claujulian.clinica.modelo.consulta;

import jakarta.validation.constraints.NotNull;

public record DatosCancelamientoConsulta(@NotNull
                                         Long idConsulta,
                                         @NotNull
                                         MotivoCancelamiento motivo) {

}
