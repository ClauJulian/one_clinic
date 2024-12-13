package com.claujulian.clinica.dto;


public record DatosRespuestaMedico(
        Long id,
        String nombre,
        String matricula,
        String telefono,
        String especialidad,
        DatosDireccion datosDireccion) {
}
