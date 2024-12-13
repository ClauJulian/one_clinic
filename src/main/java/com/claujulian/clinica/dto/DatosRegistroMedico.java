package com.claujulian.clinica.dto;

import com.claujulian.clinica.modelo.Especialidad;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DatosRegistroMedico(
        @NotBlank
        String nombre,

        @NotBlank
        @Pattern(regexp ="\\d{4,6}")
        String matricula,

        @NotBlank
        String telefono,

        @NotNull
        Especialidad especialidad,

        @NotNull
        @Valid
        DatosDireccion direccion) {
}
