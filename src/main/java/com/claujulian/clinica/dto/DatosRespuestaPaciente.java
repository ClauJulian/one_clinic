package com.claujulian.clinica.dto;


public record DatosRespuestaPaciente(
       Long id,
       String nombre,
       String email,
       String documentoIdentidad,
       String telefono,
       DatosDireccion datosDireccion
) {
}
