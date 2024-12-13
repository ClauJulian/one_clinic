package com.claujulian.clinica.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(
        @NotBlank
        String calle,
        @NotBlank
        String numero,
        @NotBlank
        String localidad,
        @NotBlank
        String provincia
) { }
